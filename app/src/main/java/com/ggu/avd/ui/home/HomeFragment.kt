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
import com.ggu.avd.utilities.provideDrawableRepository


class HomeFragment : Fragment() {

    private lateinit var viewModel:HomeViewModel

    private val args: HomeFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.avdTitle.text = findNavController().currentDestination?.label

        context?.let { context->
            viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return provideDrawableRepository(context)?.let { HomeViewModel(it) } as T
                }
            }).get(HomeViewModel::class.java)

            val listAdapter = DrawableListAdapter()

            binding.avdList.apply {
                adapter = listAdapter
                setHasFixedSize(true)
            }

            subscribeUi(listAdapter)
        }

        return binding.root
    }

    private fun subscribeUi(adapter: DrawableListAdapter) {
        viewModel.drawables.observe(viewLifecycleOwner) { drawables ->
            adapter.submitList(drawables)
        }
    }

}