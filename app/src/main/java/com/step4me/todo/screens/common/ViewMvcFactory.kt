package com.step4me.todo.screens.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.step4me.todo.screens.common.toolbar.ToolbarViewMvc
import com.step4me.todo.screens.tasks.taskitem.TaskItemViewMvc
import com.step4me.todo.screens.tasks.taskitem.TaskItemViewMvcImpl
import com.step4me.todo.screens.tasks.TasksViewMvc
import com.step4me.todo.screens.tasks.TasksViewMvcImpl

class ViewMvcFactory(private val layoutInflater: LayoutInflater) {

    fun getTasksViewMvc(parent: ViewGroup?): TasksViewMvc {
        return TasksViewMvcImpl(layoutInflater, parent, this)
    }

    fun getTaskItemViewMvc(parent: ViewGroup?): TaskItemViewMvc {
        return TaskItemViewMvcImpl(
            layoutInflater,
            parent
        )
    }

    fun getToolbarViewMvc(parent: ViewGroup?): ToolbarViewMvc {
        return ToolbarViewMvc(layoutInflater, parent)
    }
}