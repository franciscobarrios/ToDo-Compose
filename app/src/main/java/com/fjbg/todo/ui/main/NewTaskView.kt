package com.fjbg.todo.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.fjbg.todo.model.Task
import com.fjbg.todo.ui.common.defaultContentView
import com.fjbg.todo.ui.saveButton
import com.fjbg.todo.ui.tfTaskTitle

@Composable
fun newTask(
    viewModel: TaskViewModel,
    goBack: () -> Unit,
    title: String
) {
    defaultContentView(
        title = title,
        action = { },
        goBack = goBack,
        showBottomBar = false,
        content = {
            formNewTask(viewModel = viewModel)
        }
    )
}

@Composable
fun formNewTask(viewModel: TaskViewModel?) {
    Box(modifier = Modifier.padding(16.dp)) {
        Column() {
            val title = tfTaskTitle("Task title")
            val content = tfTaskTitle("Task content")
            saveButton(
                text = "Save",
                onCLick = {
                    viewModel?.addNewTask(
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

@Preview
@Composable
fun formNewTaskPreview(){
    formNewTask(viewModel = null)
}