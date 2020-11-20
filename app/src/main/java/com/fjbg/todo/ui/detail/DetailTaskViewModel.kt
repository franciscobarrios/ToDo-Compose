package com.fjbg.todo.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fjbg.todo.model.Task
import com.fjbg.todo.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailTaskViewModel @ViewModelInject constructor(
    private val repository: TaskRepository
) : ViewModel() {

    private val taskListLiveData = MutableLiveData<Task>()
    fun observeTaskDetail(): LiveData<Task> {
        return taskListLiveData
    }

    fun getTaskDetail(taskId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            taskListLiveData.postValue(repository.getTaskById(taskId))
        }
    }
}