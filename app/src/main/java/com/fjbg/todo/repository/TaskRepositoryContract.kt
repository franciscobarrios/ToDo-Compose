package com.fjbg.todo.repository

import com.fjbg.todo.model.Task

interface TaskRepositoryContract {
    suspend fun getTasks(): List<Task>
    suspend fun getTaskById(taskId: Int): Task
    suspend fun addTask(task: Task)
    suspend fun deleteTask(taskId: Int)
    suspend fun updateTask(task: Task)
}