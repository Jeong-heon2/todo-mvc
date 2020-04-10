package com.step4me.todo.screens.common.screensnavigator

import android.content.Context
import com.step4me.todo.screens.taskdetail.TaskDetailActivity

class ScreensNavigator(private val context: Context) {

    fun moveToDetailTask(taskId: String) {
        TaskDetailActivity.start(context, taskId)
    }
}