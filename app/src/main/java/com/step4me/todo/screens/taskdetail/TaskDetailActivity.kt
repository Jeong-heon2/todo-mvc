package com.step4me.todo.screens.taskdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.step4me.todo.screens.common.controllers.BaseActivity

class TaskDetailActivity: BaseActivity() {

    companion object {
        private val TAG = TaskDetailActivity::class.java.simpleName
        fun start(context: Context, taskId: String) {
            Intent(context, TaskDetailActivity::class.java).apply {
                context.startActivity(this)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate")
    }
}