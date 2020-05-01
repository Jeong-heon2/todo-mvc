package com.step4me.todo.screens.tasks

import android.os.Bundle
import com.step4me.todo.screens.common.controllers.BaseActivity
import com.step4me.todo.screens.common.screensnavigator.ScreensNavigator
import com.step4me.todo.task.FetchTaskUseCase
import com.step4me.todo.task.Task
import kotlinx.coroutines.*

class TasksActivity : BaseActivity(), TasksViewMvc.Listener, FetchTaskUseCase.Listener {

    private var viewMvc: TasksViewMvc? = null
    private var fetchTaskUseCase: FetchTaskUseCase? = null

    private var screensNavigator: ScreensNavigator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewMvc = compositionRoot?.viewMvcFactory?.getTasksViewMvc(null)
        fetchTaskUseCase = compositionRoot?.fetchTaskUseCase
        screensNavigator = compositionRoot?.screensNavigator

        setContentView(viewMvc?.getRootView())
    }

    override fun onStart() {
        super.onStart()
        viewMvc?.registerListener(this)
        fetchTaskUseCase?.registerListener(this)

        GlobalScope.launch(Dispatchers.IO) {
            fetchTaskUseCase?.fetchAllTaskAndNotify()
        }
    }

    override fun onTaskClicked(task: Task) {
        TODO("Not yet implemented")
    }

    override fun onAddTaskClicked() {
        screensNavigator?.moveToEditTask("")
    }

    override fun onTasksFetched(tasks: List<Task>) {
        viewMvc?.bindTasks(tasks)
    }
}