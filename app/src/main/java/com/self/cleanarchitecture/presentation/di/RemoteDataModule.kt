package com.self.cleanarchitecture.presentation.di

import com.self.cleanarchitecture.data.api.NewsAPIService
import com.self.cleanarchitecture.data.repository.dataSource.NewsRemoteDataSource
import com.self.cleanarchitecture.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
   fun provideNewsRemoteDateSource(newsAPIService: NewsAPIService):NewsRemoteDataSource{
       return NewsRemoteDataSourceImpl(newsAPIService)
   }

}