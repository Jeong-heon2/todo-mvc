package com.step4me.todo.screens.addedittask

import com.step4me.todo.screens.common.views.ObservableViewMvc
import com.step4me.todo.task.Task

interface TaskEditViewMvc: ObservableViewMvc<TaskEditViewMvc.Listener> {

    interface Listener {
        fun onEditCompleted(task: Task)
    }
}