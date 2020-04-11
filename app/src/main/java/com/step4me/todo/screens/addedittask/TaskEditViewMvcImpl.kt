package com.step4me.todo.screens.addedittask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import com.step4me.todo.R
import com.step4me.todo.screens.common.ViewMvcFactory
import com.step4me.todo.screens.common.toolbar.ToolbarViewMvc
import com.step4me.todo.screens.common.views.BaseObservableViewMvc

class TaskEditViewMvcImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?,
    viewMvcFactory: ViewMvcFactory
) : BaseObservableViewMvc<TaskEditViewMvc.Listener>(),
TaskEditViewMvc {

    private val toolbar: Toolbar
    private val toolbarViewMvc: ToolbarViewMvc

    init {
        setRootView(inflater.inflate(R.layout.layout_add_task, parent, false))

        toolbar = findViewById(R.id.tbEditTask)
        toolbarViewMvc = viewMvcFactory.getToolbarViewMvc(toolbar)
        toolbarViewMvc.setTitle("New Task")
        toolbar.addView(toolbarViewMvc.getRootView())
    }
}