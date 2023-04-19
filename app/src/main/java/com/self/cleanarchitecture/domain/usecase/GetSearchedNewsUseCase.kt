package com.self.cleanarchitecture.domain.usecase

import com.self.cleanarchitecture.data.model.APIResponse
import com.self.cleanarchitecture.data.util.Resource
import com.self.cleanarchitecture.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(searchQuery:String) : Resource<APIResponse>{
        return newsRepository.getSearchedNews(searchQuery)
    }


}