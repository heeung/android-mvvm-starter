package com.example.mvvmstarter.di

import android.content.Context
import com.example.mvvmstarter.data.local.AuthDataSource
import com.example.mvvmstarter.data.local.AuthDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Singleton
    @Provides
    fun provideAuthDatasource(
        @ApplicationContext context: Context
    ) : AuthDataSource = AuthDataSourceImpl(context)
}
