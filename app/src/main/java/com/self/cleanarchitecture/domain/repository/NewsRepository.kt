package com.self.cleanarchitecture.domain.repository

import androidx.lifecycle.LiveData
import com.self.cleanarchitecture.data.model.APIResponse
import com.self.cleanarchitecture.data.model.Article
import com.self.cleanarchitecture.data.util.Resource
import kotlinx.coroutines.flow.Flow


interface NewsRepository {

    suspend fun getNewsHeadLines(country : String, page:Int): Resource<APIResponse>
    suspend fun getSearchedNews(country:String,searchedQuery:String,page:Int) : Resource<APIResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>

}