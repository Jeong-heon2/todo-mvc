package com.step4me.todo.screens.addedittask

import com.step4me.todo.screens.common.views.ObservableViewMvc

interface TaskEditViewMvc: ObservableViewMvc<TaskEditViewMvc.Listener> {

    interface Listener {
        fun onEditCompleted()
    }
}