package com.example.mvvmstarter.ui.skeleton

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide.init
import com.example.mvvmstarter.R
import com.example.mvvmstarter.base.BaseFragment
import com.example.mvvmstarter.data.model.CommentDto
import com.example.mvvmstarter.databinding.FragmentSkeletonABinding
import com.example.mvvmstarter.databinding.FragmentSkeletonBBinding
import com.example.mvvmstarter.ui.skeleton.adapter.CommentAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

private const val TAG = "SkeletonFragmentB"
@AndroidEntryPoint
class SkeletonFragmentB : BaseFragment<FragmentSkeletonBBinding>(FragmentSkeletonBBinding::bind, R.layout.fragment_skeleton_b) {
    private val skeletonFragmentViewModel: SkeletonFragmentViewModel by viewModels()
    private lateinit var commentAdapter: CommentAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        subscribe()
        getCommentList()
    }
    private fun getCommentList() {
        skeletonFragmentViewModel.getCommentList()
    }
    private fun subscribe() {
        viewLifecycleOwner.lifecycleScope.launch {
            skeletonFragmentViewModel.commentList.collect { commentList ->
                updateCommentList(commentList)
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            skeletonFragmentViewModel.error.collectLatest {
                mActivity.showToast(it.message.toString())
            }
        }
    }
    private fun updateCommentList(list: List<CommentDto>) {
        Log.d(TAG, "updateCommentList: $list")
        commentAdapter.submitList(list)
    }
    private fun initRecyclerView() {
        commentAdapter = CommentAdapter()
        binding.commentRecyclerView.apply {
            adapter = commentAdapter
            layoutManager = LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false)
        }
    }
}