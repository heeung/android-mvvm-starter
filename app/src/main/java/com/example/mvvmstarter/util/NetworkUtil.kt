package com.example.mvvmstarter.util

import com.example.mvvmstarter.data.throwable.DataThrowable
import org.json.JSONObject
import retrofit2.Response

private fun <T> Response<T>.codeIn400Errors(): Boolean {
    return this.code() in 400..499
}

private fun <T> Response<T>.codeIn500Errors(): Boolean {
    return this.code() in 500..599
}

private fun <T> Response<T>.isDelete(): Boolean {
    return this.raw().request.method == "DELETE"
}

@Suppress("UNCHECKED_CAST")
fun <T> Response<T>.getValueOrThrow(): T {
    if (this.isSuccessful) {
        if (this.isDelete()) { return Unit as T }
        return this.body() ?: throw DataThrowable.IllegalStateThrowable()
    }

    if (codeIn500Errors()) {
        throw DataThrowable.IllegalStateThrowable()
    }

    if (codeIn400Errors()) {
        val errorResponse = errorBody()?.string()
        val jsonObject = errorResponse?.let { JSONObject(it) }
        val code = jsonObject?.getInt("code") ?: 0
        val message = jsonObject?.getString("message") ?: ""

        when (code) {
            in 100..199 -> { /* TODO Throw 추가 */ }
            in 200..299 -> { /* TODO Throw 추가 */ }
            in 300..399 -> { /* TODO Throw 추가 */ }
            in 400..499 -> { /* TODO Throw 추가 */ }
            in 500..599 -> { /* TODO Throw 추가 */ }
        }
    }
    throw DataThrowable.IllegalStateThrowable()
}
