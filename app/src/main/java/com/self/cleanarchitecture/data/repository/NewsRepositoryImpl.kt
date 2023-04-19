package com.self.cleanarchitecture.data.repository

import com.self.cleanarchitecture.data.model.APIResponse
import com.self.cleanarchitecture.data.model.Article
import com.self.cleanarchitecture.data.repository.dataSource.NewsRemoteDataSource
import com.self.cleanarchitecture.data.util.Resource
import com.self.cleanarchitecture.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource
):NewsRepository {
    override suspend fun getNewsHeadLines(country : String,page:Int): Resource<APIResponse> {
        return reponseToResource(newsRemoteDataSource.getTopHeadlines(country, page))
    }
    private fun reponseToResource(response:Response<APIResponse>) : Resource<APIResponse>{
        if(response.isSuccessful){
            response.body()?.let{ result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun getSearchedNews(searchedQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }


}