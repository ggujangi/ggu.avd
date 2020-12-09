package com.ggu.avd.utilities

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.ggu.avd.data.AvdDrawable
import com.ggu.avd.data.AvdType
import com.ggu.avd.ui.home.DrawableListAdapter
import com.ggu.avd.ui.search.TypeListAdapter

@BindingAdapter("android:items")
fun bindItemsToAdapter(view:RecyclerView, list:LiveData<List<AvdDrawable>>?){
    list?.value?.let {(view.adapter as DrawableListAdapter).submitList(it)}
}

@BindingAdapter("android:types")
fun bindTypesToAdapter(view:RecyclerView, list:LiveData<List<AvdType>>?){
    list?.value?.let {(view.adapter as TypeListAdapter).submitList(it)}
}


@BindingAdapter("android:isGone")
fun bindIsGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

@BindingAdapter("android:drawableStringResource")
fun bindDrawableResource(view: ImageView, xml: String) {
    val context = view.context
    val id = context.resources.getIdentifier(xml, "drawable", context.packageName)
    view.setImageResource(id)
}
