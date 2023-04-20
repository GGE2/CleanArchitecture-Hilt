package com.self.cleanarchitecture.data.repository.dataSource

import com.self.cleanarchitecture.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(country : String, page:Int): Response<APIResponse>
}