package com.ggu.avd.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ggu.avd.databinding.FragmentHomeBinding
import com.ggu.avd.ui.search.TypeListAdapter
import com.ggu.avd.utilities.provideDrawableRepository

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel

    private lateinit var listAdapter: DrawableListAdapter
    private lateinit var typeAdapter: TypeListAdapter

    private val args: HomeFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.avdTitle.text = findNavController().currentDestination?.label

        context ?: return binding.root

        val repository = provideDrawableRepository(requireContext())
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return repository?.let { HomeViewModel(it) } as T
            }
        }).get(HomeViewModel::class.java)

        binding.viewModel = viewModel

        typeAdapter = TypeListAdapter()
        listAdapter = DrawableListAdapter()

        // Type
        binding.typeList.apply {
            adapter = typeAdapter
            setHasFixedSize(true)
        }

        // Avd
        binding.avdList.apply {
            adapter = listAdapter
            setHasFixedSize(true)
        }

        return binding.root
    }
}