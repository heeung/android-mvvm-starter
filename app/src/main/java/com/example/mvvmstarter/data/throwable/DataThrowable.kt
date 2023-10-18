package com.example.mvvmstarter.data.throwable

sealed class DataThrowable(val code: Int, message: String) : Throwable(message) {
    // TODO 클래스 이름들 변경 필요 ( ex : AuthorizationThrowable )
    // 100번대 에러
    class Base100Throwable(code: Int, message: String) : DataThrowable(code, message)

    // 300번대 에러
    class Base300Throwable(code: Int, message: String) : DataThrowable(code, message)

    // 400번대 에러
    class Base400Throwable(code: Int, message: String) : DataThrowable(code, message)

    // 500번대 에러
    class Base500Throwable(code: Int, message: String) : DataThrowable(code, message)

    // body가 null일 때의 에러
    class IllegalStateThrowable : DataThrowable(ILLEGAL_STATE_THROWABLE_CODE, ILLEGAL_STATE_THROWABLE_MESSAGE)

    class NetworkErrorThrowable : DataThrowable(NETWORK_ERROR_CODE, NETWORK_ERROR_MESSAGE)

    companion object {
        const val ILLEGAL_STATE_THROWABLE_CODE = 999
        const val ILLEGAL_STATE_THROWABLE_MESSAGE = "잘못된 값입니다."

        const val NETWORK_ERROR_CODE = 998
        const val NETWORK_ERROR_MESSAGE = "네트워크 연결을 확인해주세요."
    }
}
