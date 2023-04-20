package com.self.cleanarchitecture.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.self.cleanarchitecture.domain.usecase.GetNewHeadlineUseCase
import com.self.cleanarchitecture.domain.usecase.GetSearchedNewsUseCase
import com.self.cleanarchitecture.domain.usecase.SaveNewsUseCase

class NewsViewModelFactory(
    private val app: Application,
    val getNewsHeadlinesUseCase : GetNewHeadlineUseCase,
    val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    val saveNewsUseCase: SaveNewsUseCase
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
            app,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase
        ) as T
    }
}