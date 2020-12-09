package com.ggu.avd.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface MyDao {/*
    @Query("SELECT * FROM my_drawables")
    fun getMyDrawables() : LiveData<List<MyDrawable>>*/

    @Transaction
    @Query("SELECT * FROM drawables WHERE id IN (SELECT DISTINCT(drawable_id) FROM my_drawables)")
    fun getMyDrawables() : LiveData<List<RelationDrawables>>

    @Insert
    suspend fun insertMyDrawable(drawable:MyDrawable) : Long

    @Insert
    suspend fun deleteMyDrawable(drawable:MyDrawable)

}