package com.fjbg.todo.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fjbg.todo.model.Task
import com.fjbg.todo.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel @ViewModelInject constructor(
    private val repository: TaskRepository
) : ViewModel() {

    // Main Tasks
    private val taskListLiveData = MutableLiveData<List<Task>>()
    fun observeTaskList(): LiveData<List<Task>> {
        return taskListLiveData
    }

    init {
        getTasks()
    }

    private fun getTasks() {
        viewModelScope.launch(Dispatchers.IO) {
            taskListLiveData.postValue(repository.getTasks())
        }
    }

    // New Tasks
    val saveTaskLiveData = MutableLiveData<Task>()
    fun observeSaveTask(): LiveData<Task> {
        return saveTaskLiveData
    }

    fun addNewTask(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTask(task)
        }
    }

    // Detail task
    private val taskDetailLiveData = MutableLiveData<Task>()
    fun observeTaskDetail(): LiveData<Task> {
        return taskDetailLiveData
    }

    fun getTaskDetail(taskId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            taskDetailLiveData.postValue(repository.getTaskById(taskId))
        }
    }
}