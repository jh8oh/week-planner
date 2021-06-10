package dev.ohjiho.weekplanner.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.ohjiho.weekplanner.data.db.dao.TaskDao
import dev.ohjiho.weekplanner.data.db.entity.TaskEntity

@Database(
    entities = [TaskEntity::class],
    version = 1,
    exportSchema = false
)
abstract class WeekPlannerDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}