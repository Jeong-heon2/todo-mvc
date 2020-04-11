package com.step4me.todo.screens.common.screensnavigator

import android.content.Context
import com.step4me.todo.screens.addedittask.TaskEditActivity

class ScreensNavigator(private val context: Context) {

    fun moveToEditTask(taskId: String) {
        TaskEditActivity.start(context, taskId)
    }
}