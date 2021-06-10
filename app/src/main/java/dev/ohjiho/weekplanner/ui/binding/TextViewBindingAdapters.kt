package dev.ohjiho.weekplanner.ui.binding

import android.graphics.Paint
import android.widget.TextView
import androidx.databinding.BindingAdapter

object TextViewBindingAdapters {

    @JvmStatic
    @BindingAdapter("strikethrough")
    fun TextView.bindingSetStrikeThrough(value: Boolean) {
        paintFlags = if (value) {
            paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}