package alyhuggan.onionarticles.ui.home

import alyhuggan.onionarticles.R
import alyhuggan.onionarticles.data.objects.Article
import alyhuggan.onionarticles.databinding.FragmentHomeBinding
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "HomeFragment"

private lateinit var binding: FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var mAdapter: ArticleAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return if (::binding.isInitialized) {
            binding.root
        } else {
            binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container, false)
            initializeViewModel()
            initializeRecyclerView()
            /*
            Functions for development purposes
                removeAllArticles()
                addDudArticles()
            */
            return binding.root
        }
    }

    private fun initializeViewModel() {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.allArticles.observe(viewLifecycleOwner, Observer { articles ->
            if (articles.isNotEmpty() && articles != null) {
                articles.let {
                    mAdapter.setArticles(it)
                }
            }
        })

    }

    private fun initializeRecyclerView() {
        mAdapter = ArticleAdapter()
        binding.articleRV.let {
            it.adapter = mAdapter
            it.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    /*
    Used for adding initial data - TODO("Should not be in UI = move to repository")
     */
    private fun addDudArticles() {
        val articleA = Article()

        val list = listOf<String>(
            "What are you swamping in my do",
            "Three wise men walked into a jar",
            "Cross eyed man goes blind",
            "Hamster saves care home"
        )

        list.forEach {
            articleA.title = it
            viewModel.insertFakeData(articleA)
        }
    }

    /*
    Used for quickly removing all created articles
     */
    private fun removeAllArticles() = viewModel.deleteAll()

}