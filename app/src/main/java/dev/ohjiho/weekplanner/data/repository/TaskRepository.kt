package dev.ohjiho.weekplanner.data.repository

import dev.ohjiho.weekplanner.data.db.dao.TaskDao
import dev.ohjiho.weekplanner.data.db.entity.TaskEntity

class TaskRepository(private val dao: TaskDao) : BaseRepository<TaskEntity, TaskDao>(dao) {
    fun getTaskFromWeek(weekOfYear: Int) = dao.getTaskFromWeek(weekOfYear)
}