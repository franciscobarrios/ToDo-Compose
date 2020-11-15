package com.fjbg.todo.ui.newtask

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fjbg.todo.model.Task
import com.fjbg.todo.ui.TAG
import com.fjbg.todo.ui.saveButton
import com.fjbg.todo.ui.tfTaskTitle

@Composable
fun NewTask(viewModel: NewTaskViewModel) {
    Scaffold(
        bodyContent = {
            form(viewModel)
        }
    )
}

@Composable
fun form(viewModel: NewTaskViewModel) {
    Surface {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            val title = tfTaskTitle("Task title")
            val content = tfTaskTitle("Task content")
            saveButton(
                text = "Save",
                onCLick = {
                    Log.d(TAG, "task: onCLick")
                    viewModel.addNewTask(
                        Task(
                            taskId = 0,
                            taskTitle = title,
                            taskContent = content,
                            taskCompleted = false
                        )
                    )
                }
            )
        }
    }
}