package com.ggu.avd.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ggu.avd.data.AvdDrawable
import com.ggu.avd.databinding.ItemAvdBinding

class AvdListAdapter(
    private val itemClickedListener: (AvdDrawable) -> Unit
) : ListAdapter<AvdDrawable, AvdListAdapter.ViewHolder>(AvdDrawable.diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAvdBinding.inflate(inflater, parent, false)
        return ViewHolder(binding, itemClickedListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item = getItem(position)
    }

    class ViewHolder(
        binding: ItemAvdBinding,
        itemClickedListener: (AvdDrawable) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        var item: AvdDrawable? = null

        init {
            item?.let {
                binding.data = it
                binding.root.setOnClickListener { v ->
                    itemClickedListener(it)
                }
            }
        }
    }
}