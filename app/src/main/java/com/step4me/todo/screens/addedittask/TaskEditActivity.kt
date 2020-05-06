package com.step4me.todo.screens.addedittask

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.step4me.todo.screens.common.controllers.BaseActivity
import com.step4me.todo.task.SaveTaskUseCase
import com.step4me.todo.task.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TaskEditActivity: BaseActivity(), TaskEditViewMvc.Listener, SaveTaskUseCase.Listener {

    companion object {
        private val TAG = TaskEditActivity::class.java.simpleName
        fun start(context: Context, taskId: String) {
            Intent(context, TaskEditActivity::class.java).apply {
                context.startActivity(this)
            }
        }
    }

    private var viewMvc: TaskEditViewMvc? = null
    private var saveTaskUseCase: SaveTaskUseCase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate")
        viewMvc = compositionRoot?.viewMvcFactory?.getTaskEditViewMvc(null)
        saveTaskUseCase = compositionRoot?.saveTaskUseCase

        setContentView(viewMvc?.getRootView())

    }

    override fun onStart() {
        super.onStart()
        viewMvc?.registerListener(this)
        saveTaskUseCase?.registerListener(this)
    }

    override fun onEditCompleted(task: Task) {
        GlobalScope.launch(Dispatchers.IO) {
            saveTaskUseCase?.saveTaskAndNotify(task)
        }
    }

    override fun onSaveTaskSuccess() {
        finish()
    }
}