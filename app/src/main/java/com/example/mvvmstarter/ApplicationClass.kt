package com.example.mvvmstarter

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.mvvmstarter.data.local.AuthDataSource
import com.example.mvvmstarter.data.local.AuthDataSourceImpl
import dagger.hilt.android.HiltAndroidApp

/**
 * 앱이 실행될 때 한번만 실행 됩니다.
 */
@HiltAndroidApp
class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()
        // TODO 카카오 sdkinit
        disableDarkMode()
        initDataSources()
    }

    // 다크모드 x
    private fun disableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    // 토큰을 preference에 저장하기 위함.
    private fun initDataSources() {
        authDataSource = AuthDataSourceImpl(applicationContext)
    }

    companion object DependencyContainer {
        lateinit var authDataSource: AuthDataSource
    }
}