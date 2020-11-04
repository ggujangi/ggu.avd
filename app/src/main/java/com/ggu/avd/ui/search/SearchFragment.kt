package com.ggu.avd.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ggu.avd.databinding.FragmentMyBinding
import com.ggu.avd.databinding.FragmentSearchBinding
import com.ggu.avd.ui.my.MyViewModel

class SearchFragment : Fragment() {

    private lateinit var searchViewModel : SearchViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        searchViewModel =
                ViewModelProvider(this).get(SearchViewModel::class.java)

        val binding = FragmentSearchBinding.inflate(inflater, container, false)
        binding.avdTitle.text = findNavController().currentDestination?.label

        return binding.root
    }

    private fun navigateToPlantListPage() {
        findNavController().popBackStack()
    }

}