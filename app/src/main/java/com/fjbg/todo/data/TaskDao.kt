package com.fjbg.todo.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fjbg.todo.model.Task

@Dao
interface TaskDao {

    @Query("select * from task")
    fun getAll(): List<Task>

    @Query("select * from task where taskId = :taskId")
    fun getTaskById(taskId: Int): LiveData<Task>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addTask(task: Task)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateTask(task: Task)

    @Query("delete from task where taskId = :taskId")
    fun deleteTask(taskId: Int)
}