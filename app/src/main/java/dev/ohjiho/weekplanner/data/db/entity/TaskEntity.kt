package dev.ohjiho.weekplanner.data.db.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import dev.ohjiho.weekplanner.data.model.Task
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "table_tasks", indices = [Index(value = ["uid"], unique = true)])
data class TaskEntity(
    override var name: String,
    override var completed: Boolean,
    override var weekOfYear: Int,
    override var info: String
) : Task {
    @IgnoredOnParcel
    @PrimaryKey(autoGenerate = true)
    override var uid: Int = 0
}