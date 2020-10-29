package com.ggu.avd.data

import androidx.recyclerview.widget.DiffUtil

data class AvdDrawable(
    val drawableId:String,
    val name:String,
    val avdType:Int,
    val xml:String
){
    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<AvdDrawable>() {
            override fun areItemsTheSame(
                oldItem: AvdDrawable,
                newItem: AvdDrawable
            ): Boolean =
                oldItem.drawableId == newItem.drawableId

            override fun areContentsTheSame(oldItem: AvdDrawable, newItem: AvdDrawable) =
                oldItem.drawableId == newItem.drawableId && oldItem.xml == newItem.xml
        }
    }
}