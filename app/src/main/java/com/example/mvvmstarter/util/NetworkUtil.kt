package com.example.mvvmstarter.util

import com.example.mvvmstarter.data.throwable.DataThrowable
import org.json.JSONObject
import retrofit2.Response

private fun <T> Response<T>.isDelete(): Boolean {
    return this.raw().request.method == "DELETE"
}

@Suppress("UNCHECKED_CAST")
fun <T> Response<T>.getValueOrThrow(): T {
    if (this.isSuccessful) {
        if (this.isDelete()) { return Unit as T }
        return this.body() ?: throw DataThrowable.IllegalStateThrowable()
    }

    // TODO 서버에 따라 다를수도?
    val errorResponse = errorBody()?.string()
    val jsonObject = errorResponse?.let { JSONObject(it) }
    val code = jsonObject?.getInt("code") ?: 0
    val message = jsonObject?.getString("message") ?: ""

    when (code) {
        in 100..199 -> { throw DataThrowable.Base100Throwable(code, message) }
        in 300..399 -> { throw DataThrowable.Base300Throwable(code, message) }
        in 400..499 -> { throw DataThrowable.Base400Throwable(code, message) }
        in 500..599 -> { throw DataThrowable.Base500Throwable(code, message) }
    }

    throw DataThrowable.IllegalStateThrowable()
}
