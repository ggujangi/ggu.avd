package com.ggu.avd.ui.my

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ggu.avd.data.MyDrawable
import com.ggu.avd.data.MyRepository
import com.ggu.avd.data.RelationDrawables

class MyViewModel internal constructor(
        myRepository: MyRepository
) : ViewModel() {

    val drawables:LiveData<List<RelationDrawables>> = myRepository.getDrawables()


}