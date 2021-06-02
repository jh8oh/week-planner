package dev.ohjiho.weekplanner.ui.task.editor

import android.widget.NumberPicker
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.ohjiho.weekplanner.data.repository.TaskRepository
import dev.ohjiho.weekplanner.util.Converters
import javax.inject.Inject

class TaskEditorViewModel @Inject constructor(private val repository: TaskRepository) :
    ViewModel(), NumberPicker.OnValueChangeListener {

    val taskName = MutableLiveData<String>()
    var diffFromCurrentWeek = 0
    val taskWeek = MutableLiveData(diffFromCurrentWeek)

    companion object {
        const val MIDDLE_VALUE = 49
        const val MAX_VALUE = 99
        const val MIN_VALUE = 0

        val DISPLAY_VALUES = (0..99).toList().mapIndexed { index, _ ->
            Converters.getDisplayFromWeekInt(index - MIDDLE_VALUE)
        }
    }

    override fun onValueChange(picker: NumberPicker?, oldVal: Int, newVal: Int) {
        if (newVal != oldVal) {
            diffFromCurrentWeek = newVal - MIDDLE_VALUE
        }
    }

    fun updateTaskWeek() {
        taskWeek.value = diffFromCurrentWeek
    }
}