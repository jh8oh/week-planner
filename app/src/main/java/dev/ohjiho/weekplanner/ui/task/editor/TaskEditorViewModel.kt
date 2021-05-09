package dev.ohjiho.weekplanner.ui.task.editor

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.ohjiho.weekplanner.data.repository.TaskRepository
import javax.inject.Inject

class TaskEditorViewModel @Inject constructor(private val repository: TaskRepository) :
    ViewModel() {

    val taskName = MutableLiveData<String>()
    val taskWeek = MutableLiveData<Int>()


}