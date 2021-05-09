package dev.ohjiho.weekplanner.ui.binding

import android.widget.NumberPicker
import androidx.databinding.BindingAdapter

object NumberPickerBindingAdapters {

    @BindingAdapter("maxValue")
    @JvmStatic
    fun NumberPicker.setMax(max: Int) {
        maxValue = max
    }

    @BindingAdapter("maxValue")
    @JvmStatic
    fun NumberPicker.setMin(min: Int) {
        minValue = min
    }

    @BindingAdapter("defaultValue")
    @JvmStatic
    fun NumberPicker.setDefaultValue(default: Int) {
        value = default
    }

    @BindingAdapter("displayValues")
    @JvmStatic
    fun NumberPicker.setDisplayValues(values: List<String>) {
        displayedValues = values.toTypedArray()
    }

    @BindingAdapter("onValueChangedListener")
    @JvmStatic
    fun NumberPicker.setListener(listener: NumberPicker.OnValueChangeListener) {
        setOnValueChangedListener(listener)
    }
}