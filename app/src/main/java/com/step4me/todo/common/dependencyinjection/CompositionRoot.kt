package com.step4me.todo.common.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.step4me.todo.database.AppDatabase
import com.step4me.todo.database.TasksRepository
import com.step4me.todo.database.TasksRepositoryImpl

class CompositionRoot {

    companion object {
        private const val DB_NAME = "tasks.db"
    }

    @Volatile
    private var tasksRepository: TasksRepository? = null
    @Volatile
    private var database: AppDatabase? = null

    fun getTasksRepository(context: Context): TasksRepository {
        val database = database ?: createDatabase(context)
        return tasksRepository ?: TasksRepositoryImpl(database.tasksDao()).apply {
            tasksRepository = this
        }
    }

    private fun createDatabase(context: Context): AppDatabase {
        synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DB_NAME
            ).build()
            database = instance
            return instance
        }
    }

}