package alyhuggan.onionarticles.ui.article

import alyhuggan.onionarticles.R
import alyhuggan.onionarticles.data.objects.Article
import alyhuggan.onionarticles.databinding.FragmentArticlesBinding
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

private const val TAG = "ArticleFragment"

class ArticleFragment : Fragment() {

    private lateinit var viewModel: ArticleViewModel
    private lateinit var binding: FragmentArticlesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_articles, container, false)
        binding.articleFragment = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViewModel()
    }

    private fun initializeViewModel() {
        Log.d(TAG, "initializeViewModel: started")
        viewModel = ViewModelProvider(this).get(ArticleViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.nextRandomArticle()
        viewModel.getRandomArticle().observe(viewLifecycleOwner, Observer { liveArticle ->
            binding.article = liveArticle
    })
    }

    fun addArticlesFragment() {
        findNavController().navigate(R.id.homeFragment)
    }

}