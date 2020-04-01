package com.step4me.todo.screens.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import com.step4me.todo.R
import com.step4me.todo.model.TodoItem
import com.step4me.todo.screens.common.BaseObservableViewMvc
import com.step4me.todo.screens.common.ViewMvcFactory

open class TodoListViewMvcImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?,
    viewMvcFactory: ViewMvcFactory
) : BaseObservableViewMvc<TodoListViewMvc.Listener>(), TodoListViewMvc {

    init {
        setRootView(inflater.inflate(R.layout.layout_todo_list, parent, false))
    }

    override fun bindTodoItems(todoItems: List<TodoItem>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}