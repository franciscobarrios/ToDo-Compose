package com.fjbg.todo.ui.main

import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
fun formNewTask(viewModel: TaskViewModel) {
    ConstraintLayout(modifier = Modifier.padding(16.dp)) {
        val title = tfTaskTitle("Task title")
        val content = tfTaskTitle("Task content")
        saveButton(
            text = "Save",
            onCLick = {
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