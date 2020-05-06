package com.step4me.todo.screens.addedittask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.step4me.todo.R
import com.step4me.todo.screens.common.ViewMvcFactory
import com.step4me.todo.screens.common.toolbar.ToolbarViewMvc
import com.step4me.todo.screens.common.views.BaseObservableViewMvc
import com.step4me.todo.task.Task

class TaskEditViewMvcImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?,
    viewMvcFactory: ViewMvcFactory
) : BaseObservableViewMvc<TaskEditViewMvc.Listener>(),
TaskEditViewMvc {

    private val toolbar: Toolbar
    private val toolbarViewMvc: ToolbarViewMvc

    private val titleInput: AppCompatEditText
    private val descriptionInput: AppCompatEditText
    private val editTaskButton: FloatingActionButton

    init {
        setRootView(inflater.inflate(R.layout.layout_add_task, parent, false))

        toolbar = findViewById(R.id.tbEditTask)
        toolbarViewMvc = viewMvcFactory.getToolbarViewMvc(toolbar)
        toolbarViewMvc.setTitle(getString(R.string.toolbar_add_task))
        toolbar.addView(toolbarViewMvc.getRootView())

        titleInput = findViewById(R.id.etTaskTitle)
        descriptionInput = findViewById(R.id.etTaskDescription)
        editTaskButton = findViewById(R.id.fabEditTask)
        editTaskButton.setOnClickListener {
            for (listener in listeners) {
                listener.onEditCompleted(
                    Task(
                        title = titleInput.text.toString(),
                        description = descriptionInput.text.toString(),
                        isCompleted = false
                    )
                )
            }
        }
    }
}