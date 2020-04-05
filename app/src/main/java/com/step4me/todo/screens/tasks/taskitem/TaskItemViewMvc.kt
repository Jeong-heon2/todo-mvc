package com.step4me.todo.screens.tasks.taskitem

import com.step4me.todo.task.Task
import com.step4me.todo.screens.common.ObservableViewMvc

interface TaskItemViewMvc: ObservableViewMvc<TaskItemViewMvc.Listener> {

    interface Listener {
        fun onTaskClicked(task: Task)
    }

    fun bindTask(task: Task)
}