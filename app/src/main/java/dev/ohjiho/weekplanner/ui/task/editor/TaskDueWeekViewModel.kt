package dev.ohjiho.weekplanner.ui.task.editor

import android.widget.NumberPicker
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.ohjiho.weekplanner.util.Converters

class TaskDueWeekViewModel(val defaultValue: Int) : ViewModel(),
    NumberPicker.OnValueChangeListener {

    val dueWeek = MutableLiveData<Int>()

    companion object {
        const val MAX_VALUE = 99
        const val MIN_VALUE = 0

        val DISPLAY_VALUES = (0..99).toList().mapIndexed { index, _ ->
            Converters.getDisplayFromWeekInt(index - 49)
        }
    }

    override fun onValueChange(picker: NumberPicker?, oldVal: Int, newVal: Int) {
        dueWeek.value = newVal
    }
}