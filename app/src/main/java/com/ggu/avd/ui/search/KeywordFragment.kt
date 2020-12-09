package com.ggu.avd.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ggu.avd.databinding.FragmentSearchKeywordBinding
import com.ggu.avd.utilities.provideSearchRepository

class KeywordFragment : Fragment() {
    private lateinit var viewModel : SearchViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentSearchKeywordBinding.inflate(inflater, container, false)

        context?.let { context ->
            viewModel = ViewModelProvider(requireActivity(), object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return provideSearchRepository(context)?.let { SearchViewModel(it) } as T
                }
            }).get(SearchViewModel::class.java)

        }

        return binding.root
    }
}