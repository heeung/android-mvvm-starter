package com.example.mvvmstarter.ui.skeleton

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmstarter.data.throwable.DataThrowable
import com.ssafy.likloud.data.repository.BaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SkeletonFragmentViewModel @Inject constructor(
    private val baseRepository: BaseRepository
)  : ViewModel() {
    fun getBase() {
        viewModelScope.launch {
            runCatching {
                // TODO api 호출 메소드
            }.onSuccess {

            }.onFailure {

            }
        }
    }
}