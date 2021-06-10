package dev.ohjiho.weekplanner.data.repository

import androidx.annotation.WorkerThread
import dev.ohjiho.weekplanner.data.db.dao.BaseDao

abstract class BaseRepository<E, D : BaseDao<E>>(private val dao: D) {

    @WorkerThread
    suspend fun insert(entity: E): Long {
        return dao.insert(entity)
    }

    @WorkerThread
    suspend fun update(entity: E) {
        dao.update(entity)
    }

    @WorkerThread
    suspend fun delete(vararg entity: E) {
        dao.delete(*entity)
    }
}