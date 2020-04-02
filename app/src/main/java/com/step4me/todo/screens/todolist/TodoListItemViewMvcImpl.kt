package com.step4me.todo.screens.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.step4me.todo.R
import com.step4me.todo.model.TodoItem
import com.step4me.todo.screens.common.BaseObservableViewMvc

class TodoListItemViewMvcImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?
) : BaseObservableViewMvc<TodoListItemViewMvc.Listener>(), TodoListItemViewMvc {

    private var todoItem: TodoItem? = null
    private var todoTitle: TextView? = null

    init {
        setRootView(inflater.inflate(R.layout.layout_todo_list_item, parent, false))
        todoTitle = findViewById(R.id.tvTodoTitle)
        getRootView().setOnClickListener {
            for (listener in listeners) {
                todoItem?.let { listener.onTodoItemClicked(it) }
            }
        }
    }

    override fun bindTodoItem(todoItem: TodoItem) {
        this.todoItem = todoItem
        todoTitle?.text = todoItem.title
    }
}