package com.example.mvvmstarter.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class AuthDto(
    @SerializedName("accessToken")
    val accessToken: String,
    @SerializedName("refreshToken")
    val refreshToken: String = "",
)