package alyhuggan.onionarticles.ui.home

import alyhuggan.onionarticles.R
import alyhuggan.onionarticles.data.objects.Article
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArticlesViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val id = view.findViewById<TextView>(R.id.article_Id)
    val title = view.findViewById<TextView>(R.id.article_Title)
}

class ArticleAdapter(): RecyclerView.Adapter<ArticlesViewHolder>() {

    private var articles = emptyList<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_article_list, parent, false)
        return ArticlesViewHolder(view)
    }

    override fun getItemCount() = articles.size

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {

        val article = articles[position]

        val id = holder.id
        val title = holder.title

        id.text = article.id.toString()
        title.text = article.title
    }

    internal fun setArticles(articles: List<Article>) {
        this.articles = articles
        notifyDataSetChanged()
    }
}