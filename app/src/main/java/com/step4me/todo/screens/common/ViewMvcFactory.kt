package com.step4me.todo.screens.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.step4me.todo.screens.todolist.TodoListItemViewMvc
import com.step4me.todo.screens.todolist.TodoListItemViewMvcImpl
import com.step4me.todo.screens.todolist.TodoListViewMvc
import com.step4me.todo.screens.todolist.TodoListViewMvcImpl

class ViewMvcFactory(private val layoutInflater: LayoutInflater) {

    fun getTodoListViewMvc(parent: ViewGroup?): TodoListViewMvc {
        return TodoListViewMvcImpl(layoutInflater, parent, this)
    }

    fun getTodoListItemViewMvc(parent: ViewGroup?): TodoListItemViewMvc {
        return TodoListItemViewMvcImpl(layoutInflater, parent)
    }

}