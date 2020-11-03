package com.ggu.avd.utilities

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) {
        View.GONE
    } else {
        View.VISIBLE
    }
}


@BindingAdapter("drawableStringResource")
fun bindDrawableResource(view: ImageView, xml: String) {
    val context = view.context
    val id = context.resources.getIdentifier(xml, "drawable", context.packageName)
    view.setImageResource(id)
}
