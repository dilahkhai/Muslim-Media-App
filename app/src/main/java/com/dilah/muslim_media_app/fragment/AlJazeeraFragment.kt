package com.dilah.muslim_media_app.fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dilah.muslim_media_app.NewsViewModel
import com.dilah.muslim_media_app.adapter.NewsAdapter
import com.dilah.muslim_media_app.databinding.FragmentAlJazeeraBinding

class AlJazeeraFragment : Fragment() {
    private var _binding: FragmentAlJazeeraBinding? = null
    private val binding get() = _binding as FragmentAlJazeeraBinding

    private var _alJazeeraNewsViewModel: NewsViewModel? = null
    private val alJazeeraNewsViewModel get() = _alJazeeraNewsViewModel as NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlJazeeraBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loadingView.root.visibility = View.VISIBLE
        _alJazeeraNewsViewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        alJazeeraNewsViewModel.alJazeeraNews()
        alJazeeraNewsViewModel.alJazeeraNews.observe(viewLifecycleOwner) {
            val mAdapter = NewsAdapter()
            mAdapter.setData(it.articles)
            Log.i(
                "AlJazeeraFragment",
                "onViewCreated: ${it.articles}"
            )
            binding.rvAljazeera.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(view.context)
            }
            binding.loadingView.root.visibility = View.GONE
        }
    }

}

