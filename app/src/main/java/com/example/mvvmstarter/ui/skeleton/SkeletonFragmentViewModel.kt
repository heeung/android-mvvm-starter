package com.example.mvvmstarter.ui.skeleton

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmstarter.data.model.CommentDto
import com.example.mvvmstarter.data.throwable.DataThrowable
import com.ssafy.likloud.data.repository.BaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SkeletonFragmentViewModel @Inject constructor(
    private val baseRepository: BaseRepository
)  : ViewModel() {

    private val _commentList = MutableStateFlow<List<CommentDto>>(emptyList())
    var commentList = _commentList.asStateFlow()

    private val _error = MutableSharedFlow<DataThrowable>()
    var error = _error.asSharedFlow()

    fun getCommentList() {
        viewModelScope.launch {
            runCatching {
                baseRepository.getCommentList()
            }.onSuccess { commentList ->
                _commentList.emit(commentList)
            }.onFailure { it ->
                if (it is DataThrowable) {
                    _error.emit(it)
                } else {
                    _error.emit(DataThrowable.NetworkErrorThrowable())
                }
            }
        }
    }
}