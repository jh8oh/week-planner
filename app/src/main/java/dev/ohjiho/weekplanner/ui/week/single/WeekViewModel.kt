package dev.ohjiho.weekplanner.ui.week.single

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import dev.ohjiho.weekplanner.data.db.entity.TaskEntity
import dev.ohjiho.weekplanner.data.repository.TaskRepository
import dev.ohjiho.weekplanner.util.getCurrentWeekInt
import javax.inject.Inject

class WeekViewModel @Inject constructor(private val repository: TaskRepository) : ViewModel() {

    lateinit var taskItemClickListener: WeekRecyclerViewAdapter.TaskItemClickListener

    val diffFromCurrentWeek = MutableLiveData(0)
    val weekTasks: LiveData<List<TaskEntity>> = Transformations.switchMap(diffFromCurrentWeek) {
        repository.getTaskFromWeek(getCurrentWeekInt() + it)
    }
    val adapter by lazy {
        WeekRecyclerViewAdapter(taskItemClickListener)
    }
}