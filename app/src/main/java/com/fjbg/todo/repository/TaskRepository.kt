package com.fjbg.todo.repository

import androidx.lifecycle.LiveData
import com.fjbg.todo.data.TaskDatabase
import com.fjbg.todo.model.Task
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val db: TaskDatabase
) : TaskRepositoryContract {

    override suspend fun getTasks(): List<Task> {
        return db.taskDao().getAll()
    }

    override suspend fun getTaskById(taskId: Int): LiveData<Task> {
        return db.taskDao().getTaskById(taskId)
    }

    override suspend fun addTask(task: Task) {
        db.taskDao().addTask(task)
    }

    override suspend fun deleteTask(taskId: Int) {
        db.taskDao().deleteTask(taskId)
    }

    override suspend fun updateTask(task: Task){
        return  db.taskDao().updateTask(task)
    }
}