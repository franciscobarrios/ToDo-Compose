package com.fjbg.todo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fjbg.todo.data.Task
import com.fjbg.todo.data.TaskDatabase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val database: TaskDatabase
) : ViewModel() {

    private val taskListLiveData = MutableLiveData<List<Task>>()
    fun observeTaskList(): LiveData<List<Task>> {
        return taskListLiveData
    }

    init {
        getTasks()
    }

    private fun getTasks() {
        val list = database.taskDao().getAll()
        taskListLiveData.postValue(list)
    }
}