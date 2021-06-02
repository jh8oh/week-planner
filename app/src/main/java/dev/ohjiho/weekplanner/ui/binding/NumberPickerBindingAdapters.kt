package dev.ohjiho.weekplanner.ui.binding

import android.widget.NumberPicker
import androidx.databinding.BindingAdapter

object NumberPickerBindingAdapters {

    @JvmStatic
    @BindingAdapter("maxValue")
    fun NumberPicker.bindingSetMaxValue(value: Int) {
        if (maxValue != value) {
            maxValue = value
        }
    }

    @JvmStatic
    @BindingAdapter("minValue")
    fun NumberPicker.bindingSetMinValue(value: Int) {
        if (minValue != value) {
            minValue = value
        }
    }

    @JvmStatic
    @BindingAdapter("displayValues")
    fun NumberPicker.bindingSetDisplayValues(values: List<String>) {
        if (!displayedValues.contentEquals(values.toTypedArray())) {
            displayedValues = values.toTypedArray()
        }
    }

    @JvmStatic
    @BindingAdapter("startingValue")
    fun NumberPicker.bindingSetStartingValue(value: Int) {
        if (this.value != value) {
            this.value = value
        }
    }

    @JvmStatic
    @BindingAdapter("wrapSelectorWheel")
    fun NumberPicker.bindingWrapSelectorWheel(value: Boolean) {
        if (wrapSelectorWheel != value) {
            wrapSelectorWheel = value
        }
    }

    @JvmStatic
    @BindingAdapter("onValueChangedListener")
    fun NumberPicker.bindingSetOnValueChangedListener(value: NumberPicker.OnValueChangeListener) {
        setOnValueChangedListener(value)
    }
}