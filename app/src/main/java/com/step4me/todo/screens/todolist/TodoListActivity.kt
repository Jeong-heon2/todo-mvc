package com.step4me.todo.screens.todolist

import android.os.Bundle
import com.step4me.todo.model.TodoItem
import com.step4me.todo.screens.common.BaseActivity

class TodoListActivity : BaseActivity(), TodoListViewMvc.Listener {

    private var viewMvc: TodoListViewMvc? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewMvc?.registerListener(this)

        setContentView(viewMvc?.getRootView())
    }

    override fun todoItemClicked(todoItem: TodoItem) {
        TODO("Not yet implemented")
    }
}