package com.jgeun.aftest.domain.di

import com.jgeun.aftest.data.repository.BroadRepository
import com.jgeun.aftest.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetBroadCategoryListUseCase(broadRepository: BroadRepository): GetBroadCategoriesUseCase {
        return GetBroadCategoriesUseCaseImpl(broadRepository)
    }

    @Provides
    @Singleton
    fun provideGetNextBroadsUseCase(broadRepository: BroadRepository): GetNextBroadsUseCase {
        return GetNextBroadsUseCaseImpl(broadRepository)
    }

    @Provides
    @Singleton
    fun provideGetCategoryBroadsUseCase(broadRepository: BroadRepository): GetCategoryBroadsUseCase {
        return GetCategoryBroadsUseCaseImpl(broadRepository)
    }
}