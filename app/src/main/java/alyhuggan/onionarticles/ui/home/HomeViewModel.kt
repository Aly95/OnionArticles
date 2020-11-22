package alyhuggan.onionarticles.ui.home

import alyhuggan.onionarticles.data.db.ArticleDatabase
import alyhuggan.onionarticles.data.db.ArticleRepository
import alyhuggan.onionarticles.data.objects.Article
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

private const val TAG = "HomeViewModel"

class HomeViewModel(application: Application) : AndroidViewModel(application) {

     var allArticles: LiveData<List<Article>>

    private val repository: ArticleRepository

    val articleEditText = MutableLiveData<String>()

    init {
        val dao = ArticleDatabase.getDatabase(application).articleDao()
        repository = ArticleRepository(dao)
        allArticles = repository.allArticles
    }

    fun insertFakeData(article: Article) {
        viewModelScope.launch {
        repository.insert(article)
        }
    }

    fun insert() {
        Log.d(TAG, "insert: started")
        if (articleEditText.value != null) {
            val article = Article()
            article.id = article.generateID()
            article.title = articleEditText.value!!

            viewModelScope.launch {
                repository.insert(
                    article
                )
            }
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