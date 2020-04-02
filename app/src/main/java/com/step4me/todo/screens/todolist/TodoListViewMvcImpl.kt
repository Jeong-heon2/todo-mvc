package com.step4me.todo.screens.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.step4me.todo.R
import com.step4me.todo.model.TodoItem
import com.step4me.todo.screens.common.BaseObservableViewMvc
import com.step4me.todo.screens.common.ViewMvcFactory

class TodoListViewMvcImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?,
    viewMvcFactory: ViewMvcFactory
) : BaseObservableViewMvc<TodoListViewMvc.Listener>(),
    TodoListViewMvc,
    TodoRecyclerAdapter.Listener {

    private var recyclerView: RecyclerView
    private var adapter: TodoRecyclerAdapter

    init {
        setRootView(inflater.inflate(R.layout.layout_todo_list, parent, false))
        adapter = TodoRecyclerAdapter(this, viewMvcFactory)
        recyclerView = findViewById(R.id.rvTodoList)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    override fun bindTodoItems(todoItems: List<TodoItem>) {
        adapter.bindTodoItems(todoItems)
    }

    override fun onTodoItemClicked(todoItem: TodoItem) {
        for (listener in listeners) {
            listener.onTodoItemClicked(todoItem)
        }
    }
}