package com.fjbg.todo.data

import androidx.room.*
import com.fjbg.todo.model.Task

@Dao
interface TaskDao {

    @Query("select * from task_table")
    fun getAll(): List<Task>

    @Query("select * from task_table where taskId = :taskId")
    fun getTaskById(taskId: Int): Task

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addTask(task: Task)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateTask(task: Task)

    @Query("delete from task_table where taskId = :taskId")
    fun deleteTask(taskId: Int)
}