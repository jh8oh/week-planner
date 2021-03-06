package dev.ohjiho.weekplanner.ui.editor

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

    val taskName by lazy { MutableLiveData(editingTask?.name) }
    val taskWeek by lazy { MutableLiveData(diffFromCurrentWeek) }

    val taskNameError = MutableLiveData<String>(null)

    override fun onValueChange(picker: NumberPicker?, oldVal: Int, newVal: Int) {
        if (newVal != oldVal) {
            diffFromCurrentWeek = newVal - MIDDLE_VALUE
        }
    }

    fun updateTaskWeek() {
        taskWeek.value = diffFromCurrentWeek
    }

    private fun getWeekOfYear() = getCurrentWeekInt() + (taskWeek.value ?: 0)

    fun trySaveTask(): Boolean {
        if (taskName.value == null) {
            taskNameError.value = "Task requires a name"
            return false
        }
        saveTask()
        return true
    }

    private fun saveTask() = viewModelScope.launch {
        editingTask?.let {
            repository.update(it.apply {
                name = taskName.value!!
                weekOfYear = getWeekOfYear()
            })
        } ?: repository.insert(
            TaskEntity(
                name = taskName.value!!,
                weekOfYear = getWeekOfYear(),
                completed = false
            )
        )
    }
}