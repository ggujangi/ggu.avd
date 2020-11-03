package com.ggu.avd.utilities

import android.content.Context

import com.ggu.avd.data.AppDatabase
import com.ggu.avd.data.DrawableRepository
import com.ggu.avd.data.MyRepository


fun provideDrawableRepository(context: Context): DrawableRepository? {
    val database: AppDatabase = AppDatabase.getInstance(context)
    return DrawableRepository.getInstance(database.drawableDao())
}

fun provideMyRepository(context: Context): MyRepository? {
    val database: AppDatabase = AppDatabase.getInstance(context)
    return MyRepository.getInstance(database.myDrawableDao())
}