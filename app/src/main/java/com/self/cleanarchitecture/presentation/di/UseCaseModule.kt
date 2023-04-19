package com.self.cleanarchitecture.presentation.di

import com.self.cleanarchitecture.domain.repository.NewsRepository
import com.self.cleanarchitecture.domain.usecase.GetNewHeadlineUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideNewsHeadLinesUseCase(
        newsRepository: NewsRepository
    ):GetNewHeadlineUseCase{
        return GetNewHeadlineUseCase(newsRepository)
    }

}