package com.self.cleanarchitecture.data.repository

import com.self.cleanarchitecture.data.model.APIResponse
import com.self.cleanarchitecture.data.model.Article
import com.self.cleanarchitecture.data.repository.dataSource.NewsLocalDataSource
import com.self.cleanarchitecture.data.repository.dataSource.NewsRemoteDataSource
import com.self.cleanarchitecture.data.util.Resource
import com.self.cleanarchitecture.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource:NewsLocalDataSource
):NewsRepository {
    override suspend fun getNewsHeadLines(country : String,page:Int): Resource<APIResponse> {
        return reponseToResource(newsRemoteDataSource.getTopHeadlines(country, page))
    }

    override suspend fun getSearchedNews(
        country: String,
        searchedQuery: String,
        page: Int
    ): Resource<APIResponse> {
        return reponseToResource(newsRemoteDataSource.getSearchedNews(country,searchedQuery,page))
    }

    private fun reponseToResource(response:Response<APIResponse>) : Resource<APIResponse>{
        if(response.isSuccessful){
            response.body()?.let{ result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }



    override suspend fun saveNews(article: Article) {
        newsLocalDataSource.saveArticleToDB(article)
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }


}