package com.step4me.todo.database

import com.step4me.todo.task.Task

interface TasksRepository {

    suspend fun getTasks(): List<Task>

    suspend fun insert(task: Task): Long

}