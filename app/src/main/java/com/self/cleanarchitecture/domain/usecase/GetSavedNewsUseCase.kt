package com.self.cleanarchitecture.domain.usecase

import com.self.cleanarchitecture.data.model.Article
import com.self.cleanarchitecture.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {

    fun execute(): Flow<List<Article>>{
        return newsRepository.getSavedNews()
    }

}