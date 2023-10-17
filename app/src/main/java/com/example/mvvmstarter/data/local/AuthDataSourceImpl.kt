package com.example.mvvmstarter.data.local

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class AuthDataSourceImpl(context: Context) : AuthDataSource {
    // 보안 강화를 위한 암호화
    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val authPreference =
        EncryptedSharedPreferences.create(
            context,
            AUTH_ENCRYPTED_PREFERENCE,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM,
        )

    /**
     * preference에 저장되어 있는 AccessToken을 Bearer 패턴과 함께 리턴합니다.
     */
    override fun getAccessToken(): String? {
        val accessToken = authPreference.getString(ACCESS_TOKEN, null) ?: return null
        return BEARER + accessToken
    }

    /**
     * AccessToken을 preference에 저장합니다.
     */
    override fun setAccessToken(newToken: String) {
        authPreference.edit().putString(ACCESS_TOKEN, newToken).apply()
    }

    /**
     * preference에 저장되어 있는 RefreshToken을 리턴합니다.
     */
    override fun getRefreshToken(): String? {
        return authPreference.getString(REFRESH_TOKEN, null)
    }

    /**
     * RefreshToken을 preference에 저장합니다.
     */
    override fun setRefreshToken(newToken: String) {
        authPreference.edit().putString(REFRESH_TOKEN, newToken).apply()
    }

    /**
     * preference의 키 값들을 초기화 합니다.
     */
    override fun resetToken() {
        authPreference.edit().putString(ACCESS_TOKEN, DEFAULT_TOKEN).apply()
        authPreference.edit().putString(REFRESH_TOKEN, DEFAULT_TOKEN).apply()
    }

    companion object {
        private const val DEFAULT_TOKEN = ""
        private const val AUTH_ENCRYPTED_PREFERENCE = "AUTH_ENCRYPTED_PREFERENCE"
        private const val ACCESS_TOKEN = "ACCESS_TOKEN"
        private const val REFRESH_TOKEN = "REFRESH_TOKEN"
        private const val BEARER = "Bearer "
    }
}