package com.ggu.avd.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ggu.avd.data.AvdType
import com.ggu.avd.databinding.ItemAvdTypeBinding

class TypeListAdapter : ListAdapter<AvdType, TypeListAdapter.ViewHolder>(AvdType.diffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAvdTypeBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
            private val binding : ItemAvdTypeBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: AvdType) {
            binding.data = item
        }
    }
}