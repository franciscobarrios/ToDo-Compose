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

class MainViewModel @ViewModelInject constructor(
    private val repository: TaskRepository
) : ViewModel() {

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
}