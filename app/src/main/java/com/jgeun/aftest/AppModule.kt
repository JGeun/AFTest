package com.jgeun.aftest

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val clientId = "af_mobilelab_dev_e0f147f6c034776add2142b425e81777"

    @Singleton
    @Provides
    @Named("clientId")
    fun provideClientId() = clientId
}