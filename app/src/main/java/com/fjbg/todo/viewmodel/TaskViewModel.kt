package com.fjbg.todo.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fjbg.todo.data.Task
import com.fjbg.todo.data.TaskRepository

class TaskViewModel @ViewModelInject constructor(
    private val repository: TaskRepository
) : ViewModel() {

    val taskListLiveData = MutableLiveData<List<Task>>()
    fun observeTaskList(): LiveData<List<Task>> {
        return taskListLiveData
    }

    val saveTaskLiveData = MutableLiveData<Task>()
    fun observeSaveTask(): LiveData<Task> {
        return saveTaskLiveData
    }

    init {
        getTasks()
    }

    private fun getTasks() {
        taskListLiveData.postValue(repository.getTask())
    }

    fun saveTask(task: Task) {
        saveTaskLiveData.postValue(task)
        repository.saveTask(task = task)
    }
}