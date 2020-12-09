package com.ggu.avd.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ggu.avd.data.AvdDrawable
import com.ggu.avd.data.AvdType
import com.ggu.avd.data.DrawableRepository

class HomeViewModel internal constructor(
        repository : DrawableRepository
) : ViewModel() {

    val drawables:LiveData<List<AvdDrawable>> = repository.getDrawables()

    val types:LiveData<List<AvdType>> = repository.getTypes()
}