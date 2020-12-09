package com.ggu.avd.utilities

import android.content.Context

import com.ggu.avd.data.AppDatabase
import com.ggu.avd.data.DrawableRepository
import com.ggu.avd.data.MyRepository
import com.ggu.avd.data.SearchRepository


fun provideDrawableRepository(context: Context): DrawableRepository? {
    val database: AppDatabase = AppDatabase.getInstance(context)
    return DrawableRepository(database.drawableDao())
}

fun provideMyRepository(context: Context): MyRepository? {
    val database: AppDatabase = AppDatabase.getInstance(context)
    return MyRepository(database.myDrawableDao())
}

fun provideSearchRepository(context: Context): SearchRepository? {
    val database: AppDatabase = AppDatabase.getInstance(context)
    return SearchRepository(database.searchDao(), context.assets)
}