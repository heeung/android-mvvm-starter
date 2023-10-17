package com.example.mvvmstarter.data.interceptor

import android.util.Log
import com.example.mvvmstarter.data.throwable.DataThrowable
import com.google.gson.Gson
import com.google.gson.JsonParser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okhttp3.internal.closeQuietly
import org.json.JSONObject
import java.io.IOException
import java.lang.Exception

class AuthInterceptor : Interceptor {
    private val gson = Gson()
    private val client = OkHttpClient.Builder().build()

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()

        try {
            // TODO 구현
        } catch (e: Exception) {
            return chain.proceed(chain.request())
        }
        return chain.proceed(chain.request())
    }
}