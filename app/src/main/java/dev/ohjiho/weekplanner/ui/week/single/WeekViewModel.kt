package dev.ohjiho.weekplanner.ui.week.single

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dev.ohjiho.weekplanner.data.db.entity.TaskEntity
import dev.ohjiho.weekplanner.data.repository.TaskRepository
import dev.ohjiho.weekplanner.util.getCurrentWeekInt
import javax.inject.Inject

class WeekViewModel @Inject constructor(private val repository: TaskRepository) : ViewModel() {

    var diffFromCurrentWeek = 0
        set(value) {
            field = value

            weekTasks = repository.getTaskFromWeek(getCurrentWeekInt() + value)
        }

    lateinit var weekTasks: LiveData<List<TaskEntity>>
    val adapter = WeekRecyclerViewAdapter()
}