package com.ggu.avd.data

class MyRepository constructor(private val myDao : MyDao) {
    fun getDrawables() = myDao.getMyDrawables()

    suspend fun addDrawable(drawableId:String){
        val drawable = MyDrawable(drawableId)
        myDao.insertMyDrawable(drawable)
    }

    suspend fun removeDrawable(drawable:MyDrawable){
        myDao.deleteMyDrawable(drawable)
    }

}