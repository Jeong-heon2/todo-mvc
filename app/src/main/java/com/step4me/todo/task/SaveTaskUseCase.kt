package com.step4me.todo.task

import android.util.Log
import com.step4me.todo.common.BaseObservable
import com.step4me.todo.database.TasksRepository

class SaveTaskUseCase(private val tasksRepository: TasksRepository): BaseObservable<SaveTaskUseCase.Listener>() {

    interface Listener {
        fun onSaveTaskSuccess()
    }

    companion object {
        private val TAG = SaveTaskUseCase::class.java.simpleName
    }

    suspend fun saveTaskAndNotify(task: Task) {
        val rowId = tasksRepository.insert(task)
        Log.i(TAG, "saveTaskAndNotify rowId=${rowId}")
        if (rowId < 0) return
        for (listener in listeners) {
            listener.onSaveTaskSuccess()
        }
    }
}