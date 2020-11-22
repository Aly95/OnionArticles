package alyhuggan.onionarticles.data.db

import alyhuggan.onionarticles.data.objects.Article
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ArticleDao {

    @Insert
    suspend fun insert(article: Article)

    @Update
    suspend fun update(article: Article)

    @Delete
    suspend fun delete(article: Article)

    @Query("DELETE FROM article_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM article_table ORDER BY id DESC")
    fun getAllArticles(): LiveData<List<Article>>

    @Query("SELECT * FROM article_table order by RANDOM() LIMIT 1")
    suspend fun getRandomArticle(): List<Article>
}