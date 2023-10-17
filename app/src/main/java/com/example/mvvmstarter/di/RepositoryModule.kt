package com.example.mvvmstarter.di

import com.example.mvvmstarter.data.service.BaseService
import com.ssafy.likloud.data.repository.BaseRepository
import com.ssafy.likloud.data.repository.BaseRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(baseService: BaseService): BaseRepository {
        return BaseRepositoryImpl(baseService)
    }
}