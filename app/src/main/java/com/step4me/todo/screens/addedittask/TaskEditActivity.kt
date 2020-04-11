package com.step4me.todo.screens.addedittask

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.step4me.todo.screens.common.controllers.BaseActivity

class TaskEditActivity: BaseActivity() {

    companion object {
        private val TAG = TaskEditActivity::class.java.simpleName
        fun start(context: Context, taskId: String) {
            Intent(context, TaskEditActivity::class.java).apply {
                context.startActivity(this)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate")
    }
}