package com.example.mvvmstarter.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ErrorDto (
    @SerializedName("errorCode")
    val errorCode: String,

    @SerializedName("httpStatus")
    val httpStatus: String,

    @SerializedName("httpStatusCode")
    val httpStatusCode: Int,

    @SerializedName("message")
    val message: String
) : Parcelable