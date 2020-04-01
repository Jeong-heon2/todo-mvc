package com.step4me.todo.screens.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.step4me.todo.screens.todolist.TodoListViewMvc
import com.step4me.todo.screens.todolist.TodoListViewMvcImpl

class ViewMvcFactory(private val layoutInflater: LayoutInflater) {

    fun getTodoListViewMvc(parent: ViewGroup?): TodoListViewMvc {
        return TodoListViewMvcImpl(layoutInflater, parent, this)
    }
}