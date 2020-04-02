package com.step4me.todo.screens.todolist

import com.step4me.todo.model.TodoItem
import com.step4me.todo.screens.common.ObservableViewMvc

interface TodoListItemViewMvc: ObservableViewMvc<TodoListItemViewMvc.Listener> {

    interface Listener {
        fun onTodoItemClicked(todoItem: TodoItem)
    }

    fun bindTodoItem(todoItem: TodoItem)
}