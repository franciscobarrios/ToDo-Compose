package com.fjbg.todo.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fjbg.todo.model.Task
import com.fjbg.todo.ui.textTaskStatus
import com.fjbg.todo.ui.theme.textStyleContent
import com.fjbg.todo.ui.theme.textStyleStatus
import com.fjbg.todo.ui.theme.textStyleTitle

@Composable
fun detailTask(
    viewModel: TaskViewModel,
    goBack: () -> Unit
) {

    viewModel.taskDetail().observeAsState().value.let { task ->
        Scaffold(
            bodyContent = {
                task?.let { item -> detailTask(item) }
            }
        )
    }
}

@Composable
fun detailTask(task: Task) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Title",
            style = textStyleTitle
        )
        Text(
            text = task.taskTitle,
            style = textStyleTitle
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Text(
            text = "Content",
            style = textStyleContent
        )
        task.taskContent?.let {
            Text(
                text = it,
                style = textStyleContent
            )
            Spacer(modifier = Modifier.padding(16.dp))
        }
        Text(
            text = "Status",
            style = textStyleStatus
        )
        Text(
            text = textTaskStatus(task.taskCompleted).toString(),
            style = textStyleStatus
        )
    }
}