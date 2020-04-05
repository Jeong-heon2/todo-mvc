package com.step4me.todo.screens.tasks.taskitem

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.step4me.todo.R
import com.step4me.todo.task.Task
import com.step4me.todo.screens.common.views.BaseObservableViewMvc

class TaskItemViewMvcImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?
) : BaseObservableViewMvc<TaskItemViewMvc.Listener>(),
    TaskItemViewMvc {

    private var task: Task? = null
    private var todoTitle: TextView? = null

    init {
        setRootView(inflater.inflate(R.layout.layout_task_item, parent, false))
        todoTitle = findViewById(R.id.tvTodoTitle)
        getRootView().setOnClickListener {
            for (listener in listeners) {
                task?.let { listener.onTaskClicked(it) }
            }
        }
    }

    override fun bindTask(task: Task) {
        this.task = task
        todoTitle?.text = task.title
    }
}