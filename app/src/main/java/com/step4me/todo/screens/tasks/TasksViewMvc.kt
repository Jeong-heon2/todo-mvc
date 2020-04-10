package com.step4me.todo.screens.tasks

import com.step4me.todo.task.Task
import com.step4me.todo.screens.common.views.ObservableViewMvc

interface TasksViewMvc:
    ObservableViewMvc<TasksViewMvc.Listener> {

    interface Listener {
        fun onTaskClicked(task: Task)

        fun onAddTaskClicked()
    }

    fun bindTasks(tasks: List<Task>)
}