package com.step4me.todo.screens.todolist

import com.step4me.todo.model.TodoItem
import com.step4me.todo.screens.common.ObservableViewMvc

interface TodoListViewMvc: ObservableViewMvc<TodoListViewMvc.Listener> {

    interface Listener {
        fun todoItemClicked(todoItem: TodoItem)
    }

    fun bindTodoItems(todoItems: List<TodoItem>)
}