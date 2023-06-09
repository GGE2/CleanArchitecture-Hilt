package com.self.cleanarchitecture.data.repository.dataSourceImpl

import com.self.cleanarchitecture.data.api.NewsAPIService
import com.self.cleanarchitecture.data.model.APIResponse
import com.self.cleanarchitecture.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
):NewsRemoteDataSource {
    override suspend fun getTopHeadlines(
        country : String,
        page:Int
    ): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country,page)
    }

    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Response<APIResponse> {
        return newsAPIService.getSearchedTopHeadlines(country, searchQuery, page)
    }
}