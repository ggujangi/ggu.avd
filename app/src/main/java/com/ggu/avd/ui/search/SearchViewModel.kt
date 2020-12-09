package com.ggu.avd.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ggu.avd.data.AvdDrawable
import com.ggu.avd.data.AvdType
import com.ggu.avd.data.SearchKeyword
import com.ggu.avd.data.SearchRepository

class SearchViewModel constructor(
        repository: SearchRepository
) : ViewModel() {

    private val mRepository = repository

    var searchResults: LiveData<List<AvdDrawable>>? = null

//    var searchTypes : List<AvdType> = mRepository.getTypes()

    /* Get recent search keywords */
    val keywords = mRepository.getKeywords()

    /* Insert search keyword */
    suspend fun insertKeyword(keyword: SearchKeyword) {
        mRepository.insert(keyword)
    }

    /* Delete keyword */
    suspend fun deleteKeyword(keyword: String) {
        mRepository.delete(keyword)
    }

    /* Delete all keywords */
    suspend fun deleteAllKeywords() {
        mRepository.deleteAll()
    }


    fun getResults(keyword: String) {
        searchResults = mRepository.getResults(keyword)
    }
}