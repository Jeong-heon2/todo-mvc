package com.step4me.todo.screens.tasks

import com.step4me.todo.task.Task
import com.step4me.todo.screens.common.ObservableViewMvc

interface TasksViewMvc: ObservableViewMvc<TasksViewMvc.Listener> {

    interface Listener {
        fun onTaskClicked(task: Task)
    }

    fun bindTasks(tasks: List<Task>)
}