package com.ggu.avd.ui.my

import android.graphics.drawable.AnimatedVectorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ggu.avd.data.RelationDrawables
import com.ggu.avd.databinding.ItemAvdBinding

class MyAdapter : ListAdapter<RelationDrawables, MyAdapter.ViewHolder>(RelationDrawables.diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAvdBinding.inflate(inflater, parent, false)
        return MyAdapter.ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
            private val binding: ItemAvdBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        var item: RelationDrawables? = null

        init {
            binding.avdIcon.setOnClickListener{
                val avd: AnimatedVectorDrawable = (it as ImageView).drawable as AnimatedVectorDrawable
                avd.start()
            }
        }

        fun bind(item: RelationDrawables) {
            this.item = item
            binding.data = item.drawable
        }
    }
}