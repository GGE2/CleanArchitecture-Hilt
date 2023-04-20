package com.self.cleanarchitecture.data.repository.dataSource

import com.self.cleanarchitecture.data.model.Article

interface NewsLocalDataSource {
    suspend fun saveArticleToDB(article:Article)
}