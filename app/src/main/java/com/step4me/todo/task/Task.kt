package com.step4me.todo.task

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "completed") val isCompleted: Boolean,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long = 0
)