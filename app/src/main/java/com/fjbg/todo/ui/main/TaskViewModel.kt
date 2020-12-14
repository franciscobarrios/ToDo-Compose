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

    private val _taskList = MutableLiveData<List<Task>>()
    fun taskList(): LiveData<List<Task>> = _taskList

    val _saveTask = MutableLiveData<Task>()
    fun saveTask(): LiveData<Task> = _saveTask

    private val _taskDetail = MutableLiveData<Task>()
    fun taskDetail(): LiveData<Task> = _taskDetail

    init {
        getTasks()
    }

    private fun getTasks() {
        viewModelScope.launch(Dispatchers.IO) {
            _taskList.postValue(repository.getTasks())
        }
    }

    fun addNewTask(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTask(task)
        }
    }

    fun getTaskDetail(taskId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _taskDetail.postValue(repository.getTaskById(taskId))
        }
    }

    fun deleteTask(taskId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteTask(taskId)
        }
    }
}