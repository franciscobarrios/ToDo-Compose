package com.fjbg.todo.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fjbg.todo.model.Task
import com.fjbg.todo.ui.common.defaultContentView
import com.fjbg.todo.ui.saveButton
import com.fjbg.todo.ui.tfTaskTitle
import com.fjbg.todo.ui.theme.textStyleTopMessage

@Composable
fun newTask(
    viewModel: TaskViewModel,
    goBack: () -> Unit
) {
    defaultContentView(
        title = "",
        action = { },
        goBack = goBack,
        drawerState = null,
        showBottomBar = false,
        content = {
            formNewTask(viewModel = viewModel)
        }
    )
}

@Composable
fun formNewTask(viewModel: TaskViewModel?) {
    Box {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Create a new task",
                style = textStyleTopMessage
            )
            Spacer(modifier = Modifier.padding(18.dp))
            val title = tfTaskTitle("Title")
            Spacer(modifier = Modifier.padding(18.dp))
            val content = tfTaskTitle("Content")
            Spacer(modifier = Modifier.padding(18.dp))
            saveButton(
                text = "Save",
                enabled = title.isNotBlank(),
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