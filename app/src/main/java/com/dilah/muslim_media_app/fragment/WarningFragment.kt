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
import com.dilah.muslim_media_app.databinding.FragmentCommonBinding
import com.dilah.muslim_media_app.databinding.FragmentWarningBinding

class WarningFragment : Fragment() {
    private var _binding: FragmentWarningBinding? = null
    private val binding get() = _binding as FragmentWarningBinding

    private var _warningMuslimNewsViewModel: NewsViewModel? = null
    private val warningMuslimNewsViewModel get() = _warningMuslimNewsViewModel as NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWarningBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loadingView.root.visibility = View.VISIBLE
        _warningMuslimNewsViewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        warningMuslimNewsViewModel.warningForMuslimNews()
        warningMuslimNewsViewModel.warningForMuslimNews.observe(viewLifecycleOwner) {
            val mAdapter = NewsAdapter()
            mAdapter.setData(it.articles)
            Log.i(
                "WarningFragment",
                "onViewCreated: ${it.articles}"
            )
            binding.rvWarning.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(view.context)
            }
            binding.loadingView.root.visibility = View.GONE
        }
    }
}