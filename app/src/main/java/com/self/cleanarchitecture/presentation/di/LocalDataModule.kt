package com.self.cleanarchitecture.presentation.di

import com.self.cleanarchitecture.data.db.ArticleDAO
import com.self.cleanarchitecture.data.repository.dataSource.NewsLocalDataSource
import com.self.cleanarchitecture.data.repository.dataSourceImpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Provides
    @Singleton
    fun provideNewsLocalDataSource(articleDAO: ArticleDAO) : NewsLocalDataSource{
        return NewsLocalDataSourceImpl(articleDAO)
    }
}