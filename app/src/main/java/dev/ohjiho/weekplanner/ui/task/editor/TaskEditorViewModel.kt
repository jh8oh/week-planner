package dev.ohjiho.weekplanner.ui.task.editor

import android.widget.NumberPicker
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.ohjiho.weekplanner.data.db.entity.TaskEntity
import dev.ohjiho.weekplanner.data.repository.TaskRepository
import dev.ohjiho.weekplanner.util.Constants.MIDDLE_VALUE
import dev.ohjiho.weekplanner.util.getCurrentWeekInt
import kotlinx.coroutines.launch
import javax.inject.Inject

class TaskEditorViewModel @Inject constructor(private val repository: TaskRepository) :
    ViewModel(), NumberPicker.OnValueChangeListener {

    var editingTask: TaskEntity? = null
    var diffFromCurrentWeek = 0

    val taskName = MutableLiveData(editingTask?.name)
    val taskWeek = MutableLiveData(diffFromCurrentWeek)
    val taskInfo = MutableLiveData(editingTask?.info)

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
    private fun getTaskInfo() = taskInfo.value.orEmpty()

    fun saveTask() = viewModelScope.launch {
        editingTask?.let {
            repository.update(it.apply {
                name = getTaskName()
                weekOfYear = getWeekOfYear()
                info = getTaskInfo()
            })
        } ?: repository.insert(
            TaskEntity(
                name = getTaskName(),
                weekOfYear = getWeekOfYear(),
                completed = false,
                info = getTaskInfo()
            )
        )
    }
}