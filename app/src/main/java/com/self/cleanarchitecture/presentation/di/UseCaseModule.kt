package com.self.cleanarchitecture.presentation.di

import com.self.cleanarchitecture.domain.repository.NewsRepository
import com.self.cleanarchitecture.domain.usecase.GetNewHeadlineUseCase
import com.self.cleanarchitecture.domain.usecase.GetSearchedNewsUseCase
import com.self.cleanarchitecture.domain.usecase.SaveNewsUseCase
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


    @Provides
    @Singleton
    fun provideSearchedNewsUseCase(
        newsRepository: NewsRepository
    ):GetSearchedNewsUseCase{
        return GetSearchedNewsUseCase(newsRepository)
    }
    @Provides
    @Singleton
    fun provideSaveNewsUseCase(
        newsRepository: NewsRepository
    ):SaveNewsUseCase{
        return SaveNewsUseCase(newsRepository)
    }
}