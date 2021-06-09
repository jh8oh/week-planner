package dev.ohjiho.weekplanner.ui.binding

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

object TextInputLayoutBindingAdapters {

    @JvmStatic
    @BindingAdapter("error")
    fun TextInputLayout.bindingSetError(error: String?){
        setError(error)
    }
}