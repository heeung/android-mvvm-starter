package com.example.mvvmstarter.data.throwable

sealed class DataThrowable(val code: Int, message: String) : Throwable(message) {
    // 100번대 에러

    // 200번대 에러

    // 300번대 에러

    // 400번대 에러

    // 500번대 에러

    // http 응답코드 500번대, body가 null일 때의 에러
    class IllegalStateThrowable : DataThrowable(ILLEGAL_STATE_THROWABLE_CODE, ILLEGAL_STATE_THROWABLE_MESSAGE)

    companion object {
        const val ILLEGAL_STATE_THROWABLE_CODE = 900
        const val ILLEGAL_STATE_THROWABLE_MESSAGE = "잘못된 값입니다."
    }
}
