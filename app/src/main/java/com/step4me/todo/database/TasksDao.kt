package com.step4me.todo.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.step4me.todo.task.Task

@Dao
interface TasksDao {

    @Query("SELECT * FROM tasks")
    fun getTasks(): List<Task>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task): Long

}