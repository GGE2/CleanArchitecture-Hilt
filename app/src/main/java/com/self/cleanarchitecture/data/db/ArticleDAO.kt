package com.self.cleanarchitecture.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.self.cleanarchitecture.data.model.Article

@Dao
interface ArticleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

}