package com.jgeun.aftest.data.di

import com.jgeun.aftest.data.service.BroadService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    fun provideBroadService(retrofit: Retrofit): BroadService {
        return retrofit.create(BroadService::class.java)
    }
}