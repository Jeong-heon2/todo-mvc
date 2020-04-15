package com.step4me.todo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.step4me.todo.task.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun tasksDao() : TasksDao

}