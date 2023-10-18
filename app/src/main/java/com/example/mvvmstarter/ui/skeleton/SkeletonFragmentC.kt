package com.example.mvvmstarter.ui.skeleton

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mvvmstarter.R
import com.example.mvvmstarter.base.BaseFragment
import com.example.mvvmstarter.databinding.FragmentSkeletonABinding
import com.example.mvvmstarter.databinding.FragmentSkeletonCBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SkeletonFragmentC : BaseFragment<FragmentSkeletonCBinding>(FragmentSkeletonCBinding::bind, R.layout.fragment_skeleton_c) {
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