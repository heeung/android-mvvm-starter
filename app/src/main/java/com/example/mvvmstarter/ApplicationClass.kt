package com.example.mvvmstarter

import android.app.Application
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.util.Base64
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * 앱이 실행될 때 한번만 실행 됩니다.
 */
@HiltAndroidApp
class ApplicationClass : Application() {
    // 로직
}