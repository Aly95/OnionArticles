package alyhuggan.onionarticles.data.db

import alyhuggan.onionarticles.data.objects.Article
import androidx.lifecycle.LiveData

class ArticleRepository(val articleDao: ArticleDao) {

    val allArticles: LiveData<List<Article>> = articleDao.getAllArticles()

    suspend fun insert(article: Article) {
        articleDao.insert(article)
    }

    suspend fun update(article: Article) {
        articleDao.update(article)
    }

    suspend fun delete(article: Article) {
        articleDao.delete(article)
    }

    suspend fun deleteAll() {
        articleDao.deleteAll()
    }
}