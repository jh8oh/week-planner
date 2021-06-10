package dev.ohjiho.weekplanner.ui.week.single.options

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.ohjiho.weekplanner.data.db.entity.TaskEntity
import dev.ohjiho.weekplanner.data.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class TaskOptionsBottomSheetViewModel @Inject constructor(private val repository: TaskRepository) :
    ViewModel() {

    lateinit var task: TaskEntity

    fun completeTask() = viewModelScope.launch {
        repository.update(task.apply {
            completed = true
        })
    }

    fun uncompleteTask() = viewModelScope.launch {
        repository.update(task.apply {
            completed = false
        })
    }

    fun procrastinateTask() = viewModelScope.launch {
        repository.update(task.apply {
            weekOfYear++
        })
    }

    fun deleteTask() = viewModelScope.launch {
        repository.delete(task)
    }

}