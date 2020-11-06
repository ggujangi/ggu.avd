package com.ggu.avd.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SearchDao {

    /* Insert recent search keyword */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertKeyword()

    /* Select recent search keywords order by date */
    @Query("SELECT * FROM keywords ORDER BY insertDate DESC")
    fun getKeywords() : LiveData<List<SearchKeyword>>

    /* Delete keyword */
    @Query("DELETE FROM keywords WHERE keyword = :keyword")
    fun deleteKeyword(keyword:String)

    /* Delete all keywords */
    @Query("DELETE FROM keywords")
    fun deleteAllKeywords()
}