package com.ggu.avd.ui.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.ggu.avd.R
import com.ggu.avd.databinding.FragmentMyBinding
import com.ggu.avd.utilities.AVD_COMMON_TYPE
import com.google.android.material.bottomnavigation.BottomNavigationView

class MyFragment : Fragment() {

    private lateinit var myViewModel: MyViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        myViewModel =
                ViewModelProvider(this).get(MyViewModel::class.java)

        val binding = FragmentMyBinding.inflate(inflater, container, false)
        binding.avdTitle.text = findNavController().currentDestination?.label
        binding.hasDrawables = false


        binding.addBtn.setOnClickListener {
            navigateToDrawableListPage()
        }
        return binding.root
    }

    private fun navigateToDrawableListPage() {
        /*val direction = MyFragmentDirections.actionMyFragmentToCommonFragment(AVD_COMMON_TYPE)
        findNavController().navigate(direction)*/
        findNavController().popBackStack()
    }
}