package com.ggu.avd.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AvdDao {
    @Query("SELECT * FROM drawables ORDER BY name")
    fun getDrawables() : LiveData<List<AvdDrawable>>

    @Query("SELECT * FROM drawables WHERE avdType = :type ORDER BY name")
    fun getDrawablesWithType(type:Int) : LiveData<List<AvdDrawable>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(drawables:List<AvdDrawable>)
}