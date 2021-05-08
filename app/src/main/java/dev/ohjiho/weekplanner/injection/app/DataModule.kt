package dev.ohjiho.weekplanner.injection.app

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dev.ohjiho.weekplanner.data.db.WeekPlannerDatabase
import dev.ohjiho.weekplanner.data.db.dao.TaskDao
import dev.ohjiho.weekplanner.data.repository.TaskRepository

@Module
class DataModule {

    // Database
    @ApplicationScope
    @Provides
    fun provideDatabase(context: Context) =
        Room.databaseBuilder(context, WeekPlannerDatabase::class.java, DATABASE_NAME).build()

    // DAOs
    @ApplicationScope
    @Provides
    fun provideTaskDao(database: WeekPlannerDatabase) = database.taskDao()

    // Repositories
    @ApplicationScope
    @Provides
    fun provideTaskRepository(dao: TaskDao) = TaskRepository(dao)

    companion object {
        const val DATABASE_NAME = "WeekPlannerDatabase"
    }
}