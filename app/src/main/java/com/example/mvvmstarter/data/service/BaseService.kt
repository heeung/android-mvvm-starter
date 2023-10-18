package com.example.mvvmstarter.data.service

import com.example.mvvmstarter.data.model.CommentDto
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*


interface BaseService {
    // TODO 서비스 로직
    @GET("comments")
    suspend fun getComments(): Response<List<CommentDto>>
}