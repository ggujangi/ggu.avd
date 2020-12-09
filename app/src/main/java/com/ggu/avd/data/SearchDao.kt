package com.ggu.avd.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SearchDao {

    /* Select search result list*/
    @Query("SELECT * FROM drawables WHERE id LIKE :keyword OR description LIKE :keyword OR author LIKE :keyword")
    fun getSearchResult(keyword:String) : LiveData<List<AvdDrawable>>

    /* Insert recent search keyword */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKeyword(keyword:SearchKeyword)

    /* Select recent search keywords order by date */
    @Query("SELECT * FROM keywords ORDER BY insertDate DESC")
    fun getKeywords() : LiveData<List<SearchKeyword>>

    /* Delete keyword */
    @Query("DELETE FROM keywords WHERE keyword = :keyword")
    suspend fun deleteKeyword(keyword:String)

    /* Delete all keywords */
    @Query("DELETE FROM keywords")
    suspend fun deleteAllKeywords()
}