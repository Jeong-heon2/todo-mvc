package com.step4me.todo.task

import com.step4me.todo.common.BaseObservable
import com.step4me.todo.database.TasksRepository

class FetchTaskUseCase(private val tasksRepository: TasksRepository): BaseObservable<FetchTaskUseCase.Listener>() {

    interface Listener {
        fun onTasksFetched(tasks: List<Task>)
    }

    suspend fun fetchAllTaskAndNotify() {
        val tasks = tasksRepository.getTasks()
        if (tasks.isEmpty()) return
        for (listener in listeners) {
            listener.onTasksFetched(tasks)
        }
    }
}