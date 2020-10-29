package com.ggu.avd.ui.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ggu.avd.R

class MyFragment : Fragment() {

    private lateinit var myViewModel: MyViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        myViewModel =
                ViewModelProvider(this).get(MyViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_my, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        myViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}