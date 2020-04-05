package com.step4me.todo.screens.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.step4me.todo.R
import com.step4me.todo.task.Task
import com.step4me.todo.screens.common.views.BaseObservableViewMvc
import com.step4me.todo.screens.common.ViewMvcFactory

class TasksViewMvcImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?,
    viewMvcFactory: ViewMvcFactory
) : BaseObservableViewMvc<TasksViewMvc.Listener>(),
    TasksViewMvc,
    TasksRecyclerAdapter.Listener {

    private var recyclerView: RecyclerView
    private var adapter: TasksRecyclerAdapter

    init {
        setRootView(inflater.inflate(R.layout.layout_tasks, parent, false))
        adapter = TasksRecyclerAdapter(this, viewMvcFactory)
        recyclerView = findViewById(R.id.rvTodoList)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
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