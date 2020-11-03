package com.ggu.avd.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ggu.avd.data.AvdDrawable
import com.ggu.avd.data.DrawableRepository
import com.squareup.inject.assisted.AssistedInject

class ListViewModel internal constructor(
        drawableRepository: DrawableRepository
) : ViewModel() {

    val drawables:LiveData<List<AvdDrawable>> = drawableRepository.getDrawables()

}