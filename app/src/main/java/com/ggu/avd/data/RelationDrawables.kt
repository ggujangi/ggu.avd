package com.ggu.avd.data

import androidx.recyclerview.widget.DiffUtil
import androidx.room.Embedded
import androidx.room.Relation

/**
 * This class captures the relationship between a [AvdDrawable] and a user's [MyDrawable], which is
 * used by Room to fetch the related entities.
 */
data class RelationDrawables (
    @Embedded
    val drawable:AvdDrawable,

    @Relation(parentColumn = "id", entityColumn = "drawable_id")
    val myDrawables : List<MyDrawable> = emptyList()
){
    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<RelationDrawables>() {
            override fun areItemsTheSame(
                    oldItem: RelationDrawables,
                    newItem: RelationDrawables
            ): Boolean =
                    oldItem.drawable.drawableId == newItem.drawable.drawableId

            override fun areContentsTheSame(oldItem: RelationDrawables, newItem: RelationDrawables) =
                    oldItem.drawable.drawableId == newItem.drawable.drawableId
        }
    }
}