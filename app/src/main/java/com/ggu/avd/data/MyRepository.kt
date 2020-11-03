package com.ggu.avd.data

class MyRepository constructor(private val myDao : MyDao) {
    companion object {
        @Volatile
        private var instance: MyRepository? = null

        fun getInstance(myDao : MyDao): MyRepository {
            return instance ?: synchronized(this) {
                instance ?: MyRepository(myDao)
            }
        }
    }

    suspend fun addDrawable(drawableId:String){
        val drawable = MyDrawable(drawableId)
        myDao.insertMyDrawable(drawable)
    }

    suspend fun removeDrawable(drawable:MyDrawable){
        myDao.deleteMyDrawable(drawable)
    }

}