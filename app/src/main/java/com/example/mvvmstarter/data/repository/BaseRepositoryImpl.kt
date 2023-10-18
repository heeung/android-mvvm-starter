package com.ssafy.likloud.data.repository


import com.example.mvvmstarter.data.model.CommentDto
import com.example.mvvmstarter.data.service.BaseService
import com.example.mvvmstarter.util.handleApi
import javax.inject.Inject

private const val TAG = "BaseRepositoryImpl_싸피"
class BaseRepositoryImpl @Inject constructor(
    private val baseService: BaseService
) : BaseRepository {
    // TODO 구현할 메소드
    override suspend fun getCommentList(): List<CommentDto> {
        return handleApi { baseService.getComments() }
    }
}