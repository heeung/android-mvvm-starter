package com.example.mvvmstarter.ui.skeleton

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide.init
import com.example.mvvmstarter.R
import com.example.mvvmstarter.base.BaseFragment
import com.example.mvvmstarter.databinding.FragmentSkeletonBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SkeletonFragment : BaseFragment<FragmentSkeletonBinding>(FragmentSkeletonBinding::bind, R.layout.fragment_skeleton) {
    private val skeletonFragmentViewModel: SkeletonFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}