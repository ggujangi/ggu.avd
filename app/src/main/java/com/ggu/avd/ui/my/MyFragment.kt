package com.ggu.avd.ui.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ggu.avd.databinding.FragmentMyBinding
import com.ggu.avd.utilities.provideMyRepository

class MyFragment : Fragment() {

    private lateinit var viewModel: MyViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentMyBinding.inflate(inflater, container, false)
        binding.avdTitle.text = findNavController().currentDestination?.label

        binding.addBtn.setOnClickListener {
            navigateToDrawableListPage()
        }

        context?.let { context ->
            viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return provideMyRepository(context)?.let { MyViewModel(it) } as T
                }
            }).get(MyViewModel::class.java)

            val listAdapter = MyAdapter()
            binding.avdList.apply {
                adapter = listAdapter
                setHasFixedSize(true)
            }

            subscribeUi(binding, listAdapter)
        }

        return binding.root
    }

    private fun subscribeUi(binding:FragmentMyBinding, adapter:MyAdapter) {
        viewModel.drawables.observe(viewLifecycleOwner) { result ->
            binding.hasDrawables = !result.isNullOrEmpty()
            adapter.submitList(result)
        }
    }

    private fun navigateToDrawableListPage() {
        /*val direction = MyFragmentDirections.actionMyFragmentToCommonFragment(AVD_COMMON_TYPE)
        findNavController().navigate(direction)*/
        findNavController().popBackStack()
    }
}