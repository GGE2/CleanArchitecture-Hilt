package com.self.cleanarchitecture.domain.usecase

import com.self.cleanarchitecture.data.model.APIResponse
import com.self.cleanarchitecture.data.util.Resource
import com.self.cleanarchitecture.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country:String,searchQuery:String,page:Int) : Resource<APIResponse>{
        return newsRepository.getSearchedNews(country,searchQuery,page)
    }


}