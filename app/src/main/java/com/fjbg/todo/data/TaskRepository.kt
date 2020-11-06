package com.fjbg.todo.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class TaskRepository @Inject constructor(
    private val database: TaskDatabase
) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var task: TaskDao? = null

    fun getTask() = task?.getAll()

    fun saveTask(task: Task) {
        launch {
            saveTaskCoroutine(task)
        }
    }

    private suspend fun saveTaskCoroutine(task: Task) {
        withContext(Dispatchers.IO) {
            database.taskDao().addTask(task)
        }
    }
}