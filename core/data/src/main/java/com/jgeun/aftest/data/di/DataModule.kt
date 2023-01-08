package com.jgeun.aftest.data.di

import com.jgeun.aftest.data.repository.BroadRepository
import com.jgeun.aftest.data.repository.BroadRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsBroadRepository(
        broadRepositoryImpl: BroadRepositoryImpl
    ) : BroadRepository

}