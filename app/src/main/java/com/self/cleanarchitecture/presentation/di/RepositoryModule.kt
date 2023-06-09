package com.self.cleanarchitecture.presentation.di

import com.self.cleanarchitecture.data.repository.NewsRepositoryImpl
import com.self.cleanarchitecture.data.repository.dataSource.NewsLocalDataSource
import com.self.cleanarchitecture.data.repository.dataSource.NewsRemoteDataSource
import com.self.cleanarchitecture.domain.repository.NewsRepository
import com.self.cleanarchitecture.domain.usecase.SaveNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {


    @Singleton
    @Provides
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
        localDataSource: NewsLocalDataSource
    ):NewsRepository{
        return NewsRepositoryImpl(newsRemoteDataSource,localDataSource)
    }

}