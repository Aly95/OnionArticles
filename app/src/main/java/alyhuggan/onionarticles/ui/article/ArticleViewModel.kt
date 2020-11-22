package alyhuggan.onionarticles.ui.article

import alyhuggan.onionarticles.data.db.ArticleDatabase
import alyhuggan.onionarticles.data.db.ArticleRepository
import alyhuggan.onionarticles.data.objects.Article
import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch

private const val TAG = "ArticleViewModel"

class ArticleViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ArticleRepository
    private var articleList: LiveData<List<Article>>

    private var _randomArticle = MutableLiveData<Article>()

    init {
        val dao = ArticleDatabase.getDatabase(application).articleDao()
        repository = ArticleRepository(dao)
        articleList = repository.allArticles
        nextRandomArticle()
    }

    fun getRandomArticle() = _randomArticle

    fun nextRandomArticle() {
        Log.d(TAG, "nextRandomArticle: started")
        viewModelScope.launch {
            _randomArticle.value = repository.getRandomArticle()[0]
        }
    }
}