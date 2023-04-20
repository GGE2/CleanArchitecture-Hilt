package com.self.cleanarchitecture.data.repository.dataSourceImpl

import com.self.cleanarchitecture.data.db.ArticleDAO
import com.self.cleanarchitecture.data.model.Article
import com.self.cleanarchitecture.data.repository.dataSource.NewsLocalDataSource

class NewsLocalDataSourceImpl(
    private val articleDAO:ArticleDAO
) : NewsLocalDataSource {
    override suspend fun saveArticleToDB(article: Article) {
        articleDAO.insert(article)
    }
}