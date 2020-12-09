package com.ggu.avd.data

import android.content.res.AssetManager
import android.util.Log
import com.ggu.avd.utilities.TYPE_DATA_FILENAME

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import java.lang.Exception

class SearchRepository constructor(
        private val searchDao: SearchDao,
        private val assetManager: AssetManager) {

    /* Get drawable type list (Categories) */


    /* Get search results */
    fun getResults(keyword:String) = searchDao.getSearchResult(keyword)


    /* Get search keywords */
    fun getKeywords() = searchDao.getKeywords()


    /* Insert search keyword */
    suspend fun insert(keyword: SearchKeyword) {
        searchDao.insertKeyword(keyword)
    }


    /* Delete keyword */
    suspend fun delete(keyword:String){
        searchDao.deleteKeyword(keyword)
    }


    /* Delete all keywords */
    suspend fun deleteAll() {
        searchDao.deleteAllKeywords()
    }
}