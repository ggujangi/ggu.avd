package com.ggu.avd.data

interface LoadDataCallback<T> {
    fun onDataLoaded(data: T);
    fun onDataNotAvailable(error: String)
}