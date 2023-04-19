package com.self.cleanarchitecture.domain.usecase

import com.self.cleanarchitecture.data.model.Article
import com.self.cleanarchitecture.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article:Article) = newsRepository.deleteNews(article)
}