package com.example.mvvmstarter.ui.skeleton.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmstarter.R
import com.example.mvvmstarter.data.model.CommentDto
import com.example.mvvmstarter.databinding.CommentItemBinding

class CommentAdapter() : ListAdapter<CommentDto, CommentAdapter.CommentListHolder>(CommentListComparator) {
    companion object CommentListComparator : DiffUtil.ItemCallback<CommentDto>() {
        override fun areItemsTheSame(oldItem: CommentDto, newItem: CommentDto): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CommentDto, newItem: CommentDto): Boolean {
            return oldItem.id  == newItem.id
        }
    }
    inner class CommentListHolder(private val binding: CommentItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindInfo(comment : CommentDto){
            binding.tvName.text = comment.name
            binding.tvEmail.text = comment.email
            binding.tvBody.text = comment.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentListHolder {
        return CommentListHolder(
            CommentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CommentListHolder, position: Int) {
        holder.bindInfo(getItem(position))
    }
}