package com.step4me.todo.database

import com.step4me.todo.task.Task
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class TasksRepositoryImpl(private val tasksDao: TasksDao): TasksRepository {

    override suspend fun getTasks(): List<Task> {
        return tasksDao.getTasks()
    }

    override suspend fun insert(task: Task): Long {
        return tasksDao.insertTask(task)
    }
}