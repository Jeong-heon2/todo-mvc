package com.step4me.todo.screens.tasks

import android.os.Bundle
import com.step4me.todo.task.Task
import com.step4me.todo.screens.common.BaseActivity

class TasksActivity : BaseActivity(), TasksViewMvc.Listener {

    private var viewMvc: TasksViewMvc? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewMvc = compositionRoot?.viewMvcFactory?.getTasksViewMvc(null)
        viewMvc?.registerListener(this)

        setContentView(viewMvc?.getRootView())

        // TODO: remove test code
        viewMvc?.bindTasks(listOf(
            Task("1", "First Task"),
            Task("2", "Second Task")
        ))
    }

    override fun onTaskClicked(task: Task) {
        TODO("Not yet implemented")
    }
}