package com.ggu.avd.data

class DrawableRepository constructor(private val drawableDao: AvdDao) {

    fun getDrawables() = drawableDao.getDrawables()

    fun getDrawablesWithType(type:Int) = drawableDao.getDrawablesWithType(type)

    fun isMyDrawable(drawableId:String) = drawableDao.isMyDrawable(drawableId)

    fun getTypes() = drawableDao.getTypes()
}