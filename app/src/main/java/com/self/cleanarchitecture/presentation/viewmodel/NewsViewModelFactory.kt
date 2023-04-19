package com.self.cleanarchitecture.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.self.cleanarchitecture.domain.usecase.GetNewHeadlineUseCase

class NewsViewModelFactory(
    private val app: Application,
    val getNewsHeadlinesUseCase : GetNewHeadlineUseCase
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
            app,
            getNewsHeadlinesUseCase
        ) as T
    }
}