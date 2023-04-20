package com.self.cleanarchitecture.presentation.di

import android.app.Application
import com.self.cleanarchitecture.domain.usecase.GetNewHeadlineUseCase
import com.self.cleanarchitecture.domain.usecase.GetSearchedNewsUseCase
import com.self.cleanarchitecture.domain.usecase.SaveNewsUseCase
import com.self.cleanarchitecture.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Provides
    @Singleton
    fun provideNewsViewModelFactory(
        application: Application,
        getNewHeadlineUseCase: GetNewHeadlineUseCase,
        getSearchedNewsUseCase: GetSearchedNewsUseCase,
        saveNewsUseCase: SaveNewsUseCase
    ):NewsViewModelFactory{
        return NewsViewModelFactory(
            application,getNewHeadlineUseCase,getSearchedNewsUseCase,saveNewsUseCase
        )
    }

}