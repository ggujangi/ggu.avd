package com.ggu.avd.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ggu.avd.databinding.FragmentSearchResultBinding

class ResultFragment : Fragment() {
    private lateinit var searchViewModel : SearchViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        searchViewModel =
                ViewModelProvider(requireActivity()).get(SearchViewModel::class.java)

        val binding = FragmentSearchResultBinding.inflate(inflater, container, false)

        return binding.root
    }

    private fun navigateToPlantListPage() {
        findNavController().popBackStack()
    }
}