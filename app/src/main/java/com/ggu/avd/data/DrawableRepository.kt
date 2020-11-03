package com.ggu.avd.data

class DrawableRepository constructor(private val drawableDao: AvdDao) {
    companion object {
        @Volatile
        private var instance: DrawableRepository? = null

        fun getInstance(drawableDao: AvdDao): DrawableRepository {
            return instance ?: synchronized(this) {
                instance ?: DrawableRepository(drawableDao)
            }
        }
    }

    fun getDrawables() = drawableDao.getDrawables()

    fun getDrawablesWithType(type:Int) = drawableDao.getDrawablesWithType(type)

    fun isMyDrawable(drawableId:String) = drawableDao.isMyDrawable(drawableId)

}