package com.step4me.todo.screens.todolist

import android.os.Bundle
import com.step4me.todo.model.TodoItem
import com.step4me.todo.screens.common.BaseActivity

class TodoListActivity : BaseActivity(), TodoListViewMvc.Listener {

    private var viewMvc: TodoListViewMvc? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewMvc = compositionRoot?.viewMvcFactory?.getTodoListViewMvc(null)
        viewMvc?.registerListener(this)

        setContentView(viewMvc?.getRootView())

        // TODO: remove test code
        viewMvc?.bindTodoItems(listOf(
            TodoItem("1", "First Task"),
            TodoItem("2", "Second Task")
        ))
    }

    override fun onTodoItemClicked(todoItem: TodoItem) {
        TODO("Not yet implemented")
    }
}