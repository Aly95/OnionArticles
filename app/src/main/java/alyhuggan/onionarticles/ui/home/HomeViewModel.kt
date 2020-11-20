package alyhuggan.onionarticles.ui.home

import alyhuggan.onionarticles.data.db.ArticleDatabase
import alyhuggan.onionarticles.data.db.ArticleRepository
import alyhuggan.onionarticles.data.objects.Article
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

private const val TAG = "HomeViewModel"

class HomeViewModel (application: Application): AndroidViewModel(application) {

    private val repository: ArticleRepository
    lateinit var allArticles: LiveData<List<Article>>

    init {
        val dao = ArticleDatabase.getDatabase(application).articleDao()
        repository = ArticleRepository(dao)
        allArticles = repository.allArticles
    }

    fun insert(article: Article) {
        Log.d(TAG, "insert: started")
        viewModelScope.launch {
            repository.insert(article)
        }
    }

    fun update(article: Article) {
        viewModelScope.launch {
            repository.update(article)
        }
    }

    fun delete(article: Article) {
        viewModelScope.launch {
            repository.delete(article)
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }
}