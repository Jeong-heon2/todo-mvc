package com.step4me.todo.screens.tasks

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.step4me.todo.task.Task
import com.step4me.todo.screens.common.ViewMvcFactory
import com.step4me.todo.screens.tasks.taskitem.TaskItemViewMvc

class TasksRecyclerAdapter(
    private val listener: Listener,
    private val viewFactory: ViewMvcFactory
) : RecyclerView.Adapter<TasksRecyclerAdapter.TodoListViewHolder>(), TaskItemViewMvc.Listener {

    interface Listener {
        fun onTaskClicked(task: Task)
    }

    class TodoListViewHolder(val viewMvc: TaskItemViewMvc) :
        RecyclerView.ViewHolder(viewMvc.getRootView()) {

    }

    private val todoItems = arrayListOf<Task>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        val viewMvc = viewFactory.getTaskItemViewMvc(parent)
        viewMvc.registerListener(this)
        return TodoListViewHolder(viewMvc)
    }

    override fun getItemCount(): Int {
        return todoItems.size
    }

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        holder.viewMvc.bindTask(todoItems[position])
    }

    override fun onTaskClicked(task: Task) {
        listener.onTaskClicked(task)
    }

    fun bindTasks(tasks: List<Task>) {
        this.todoItems.addAll(tasks)
        notifyDataSetChanged()
    }
}