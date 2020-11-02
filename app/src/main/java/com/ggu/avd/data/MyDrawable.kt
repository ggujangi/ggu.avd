package com.ggu.avd.data

import androidx.room.*
import java.util.*


@Entity(
    tableName = "my_drawables",
    foreignKeys = [
            ForeignKey(entity = AvdDrawable::class, parentColumns = ["id"], childColumns = ["drawable_id"])
    ],
    indices = [Index("drawable_id")]
)
data class MyDrawable(
    @ColumnInfo(name = "drawable_id") val drawableId: String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var myDrawableId:Long = 0
}