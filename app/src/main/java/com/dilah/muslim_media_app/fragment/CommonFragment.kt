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
import com.dilah.muslim_media_app.databinding.FragmentCommonBinding

/**
 * A simple [Fragment] subclass.
 * Use the [CommonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CommonFragment : Fragment() {
    private var _binding: FragmentCommonBinding? = null
    private val binding get() = _binding as FragmentCommonBinding

    private var _commonNewsViewModel: NewsViewModel? = null
    private val commonNewsViewModel get() = _commonNewsViewModel as NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCommonBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loadingView.root.visibility = View.VISIBLE
        _commonNewsViewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        commonNewsViewModel.commonMuslimNews()
        commonNewsViewModel.commonMuslimNews.observe(viewLifecycleOwner) {
            val mAdapter = NewsAdapter()
            mAdapter.setData(it.articles)
            Log.i(
                "CommonFragment",
                "onViewCreated: ${it.articles}"
            )
            binding.rvCommon.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(view.context)
            }
            binding.loadingView.root.visibility = View.GONE
        }
    }
}