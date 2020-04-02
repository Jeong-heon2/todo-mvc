package com.step4me.todo.screens.todolist

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.step4me.todo.model.TodoItem
import com.step4me.todo.screens.common.ViewMvcFactory

class TodoRecyclerAdapter(
    private val listener: Listener,
    private val viewFactory: ViewMvcFactory
) : RecyclerView.Adapter<TodoRecyclerAdapter.TodoListViewHolder>(), TodoListItemViewMvc.Listener {

    interface Listener {
        fun onTodoItemClicked(todoItem: TodoItem)
    }

    class TodoListViewHolder(val viewMvc: TodoListItemViewMvc) :
        RecyclerView.ViewHolder(viewMvc.getRootView()) {

    }

    private val todoItems = arrayListOf<TodoItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        val viewMvc = viewFactory.getTodoListItemViewMvc(parent)
        viewMvc.registerListener(this)
        return TodoListViewHolder(viewMvc)
    }

    override fun getItemCount(): Int {
        return todoItems.size
    }

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        holder.viewMvc.bindTodoItem(todoItems[position])
    }

    override fun onTodoItemClicked(todoItem: TodoItem) {
        listener.onTodoItemClicked(todoItem)
    }

    fun bindTodoItems(todoItems: List<TodoItem>) {
        this.todoItems.addAll(todoItems)
        notifyDataSetChanged()
    }
}