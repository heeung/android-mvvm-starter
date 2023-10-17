package com.ssafy.likloud.data.repository


import com.example.mvvmstarter.data.service.BaseService
import javax.inject.Inject

private const val TAG = "BaseRepositoryImpl_싸피"
class BaseRepositoryImpl @Inject constructor(
    private val baseService: BaseService
) : BaseRepository {
    // TODO 구현할 메소드
}