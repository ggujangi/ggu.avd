package com.ggu.avd.data

import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drawables")
data class AvdDrawable(
    @PrimaryKey @ColumnInfo(name = "id") val drawableId:String,
    val name:String,
    val description:String,
    val avdType:Int,
    val xmlStart:String,
    val xmlEnd:String
){
    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<AvdDrawable>() {
            override fun areItemsTheSame(
                oldItem: AvdDrawable,
                newItem: AvdDrawable
            ): Boolean =
                oldItem.drawableId == newItem.drawableId

            override fun areContentsTheSame(oldItem: AvdDrawable, newItem: AvdDrawable) =
                oldItem.drawableId == newItem.drawableId && oldItem.xmlStart == newItem.xmlStart && oldItem.xmlEnd == newItem.xmlEnd
        }
    }

    override fun toString(): String {
        return name
    }
}