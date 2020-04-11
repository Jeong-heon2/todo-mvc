package com.step4me.todo.screens.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.step4me.todo.R
import com.step4me.todo.screens.common.ViewMvcFactory
import com.step4me.todo.screens.common.toolbar.ToolbarViewMvc
import com.step4me.todo.screens.common.views.BaseObservableViewMvc
import com.step4me.todo.task.Task

class TasksViewMvcImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?,
    viewMvcFactory: ViewMvcFactory
) : BaseObservableViewMvc<TasksViewMvc.Listener>(),
    TasksViewMvc,
    TasksRecyclerAdapter.Listener {

    private val addTaskButton: FloatingActionButton
    private val toolbar: Toolbar
    private val toolbarViewMvc: ToolbarViewMvc

    private val recyclerView: RecyclerView
    private val adapter: TasksRecyclerAdapter

    init {
        setRootView(inflater.inflate(R.layout.layout_tasks, parent, false))
        adapter = TasksRecyclerAdapter(this, viewMvcFactory)
        recyclerView = findViewById(R.id.rvTodoList)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        toolbar = findViewById(R.id.tbTasks)
        toolbarViewMvc = viewMvcFactory.getToolbarViewMvc(toolbar)
        toolbarViewMvc.setTitle(getString(R.string.toolbar_task_list))
        toolbar.addView(toolbarViewMvc.getRootView())

        addTaskButton = findViewById(R.id.fabTasks)
        addTaskButton.setOnClickListener {
            for (listener in listeners) {
                listener.onAddTaskClicked()
            }
        }
    }

    override fun bindTasks(tasks: List<Task>) {
        adapter.bindTasks(tasks)
    }

    override fun onTaskClicked(task: Task) {
        for (listener in listeners) {
            listener.onTaskClicked(task)
        }
    }
}