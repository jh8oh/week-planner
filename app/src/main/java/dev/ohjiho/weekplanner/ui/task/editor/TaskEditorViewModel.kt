package dev.ohjiho.weekplanner.ui.task.editor

import android.widget.NumberPicker
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.ohjiho.weekplanner.data.db.entity.TaskEntity
import dev.ohjiho.weekplanner.data.repository.TaskRepository
import dev.ohjiho.weekplanner.util.Converters
import dev.ohjiho.weekplanner.util.getCurrentWeekInt
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.temporal.WeekFields
import javax.inject.Inject

class TaskEditorViewModel @Inject constructor(private val repository: TaskRepository) :
    ViewModel(), NumberPicker.OnValueChangeListener {

    var editingTask: TaskEntity? = null
    var diffFromCurrentWeek = 0

    val taskName = MutableLiveData(editingTask?.name)
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

    private fun getTaskName() = taskName.value.orEmpty()
    private fun getWeekOfYear() = getCurrentWeekInt() + (taskWeek.value ?: 0)

    fun saveTask() = viewModelScope.launch {
        editingTask?.let {
            repository.update(it.apply {
                name = getTaskName()
                weekOfYear = getWeekOfYear()
            })
        } ?: repository.insert(
            TaskEntity(
                name = getTaskName(),
                weekOfYear = getWeekOfYear(),
                completed = false
            )
        )
    }
}