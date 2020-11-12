package com.fjbg.todo.ui.newtask

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fjbg.todo.model.Task
import com.fjbg.todo.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewTaskViewModel @ViewModelInject constructor(
    private val repository: TaskRepository
) : ViewModel() {

    val saveTaskLiveData = MutableLiveData<Task>()
    fun observeSaveTask(): LiveData<Task> {
        return saveTaskLiveData
    }

    fun addNewTask(task: Task) {
        GlobalScope.launch(Dispatchers.IO) {
            repository.addTask(task)
        }
    }
}