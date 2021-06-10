package dev.ohjiho.weekplanner.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import dev.ohjiho.weekplanner.data.db.entity.TaskEntity

@Dao
interface TaskDao : BaseDao<TaskEntity> {

    @Query("SELECT * FROM table_tasks WHERE weekOfYear = :weekOfYear")
    fun getTaskFromWeek(weekOfYear: Int): LiveData<List<TaskEntity>>
}