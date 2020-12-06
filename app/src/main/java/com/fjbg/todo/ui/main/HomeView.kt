package com.fjbg.todo.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.ripple.RippleIndication
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.fjbg.todo.model.Task
import com.fjbg.todo.ui.common.defaultContentView
import com.fjbg.todo.ui.textTaskStatus
import com.fjbg.todo.ui.theme.*

@Composable
fun homeView(
    viewModel: TaskViewModel,
    newTask: () -> Unit,
    title: String,
) {
    viewModel.observeTaskList().observeAsState().value.let { list ->
        defaultContentView(
            title = title,
            action = newTask,
            goBack = null,
            showBottomBar = true,
            content = {
                when (list) {
                    null -> emptyList()
                    else -> lazyColumn(list = list)
                }
            }
        )
    }
}

@Composable
fun lazyColumn(
    list: List<Task>
) {
    LazyColumnFor(
        items = list,
        modifier = Modifier.padding(
            start = 8.dp,
            top = 12.dp,
            end = 8.dp,
            bottom = 12.dp
        )
    ) { item ->
        createTaskCard(
            task = item
        )
    }
}

@Composable
fun emptyList() {
    Text(
        text = "No task to show",
        textAlign = TextAlign.Center,
        style = textStyleTitle
    )
}

@Composable
fun createTaskCard(task: Task) {
    RippleIndication(
        bounded = true
    )
    Card(
        shape = shapes.small,
        elevation = 4.dp,
        backgroundColor = almostWhite,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = {


                //val taskId = intent.getIntExtra(task_id, 0)
                //                viewModel.getTaskDetail(taskId)
                //
                //                viewModel.observeTaskDetail().observeAsState().value.let { task ->
                //                    task?.let { DetailTask(it) }
                //                }


                /*val i = Intent(context, DetailTaskActivity::class.java)
                i.putExtra(task_id, task.taskId)
                context.startActivity(i)*/
            })
    ) {
        Column {
            taskTitle(task.taskTitle)
            taskContent(task.taskContent)
            Divider(
                modifier = Modifier
                    .padding(
                        top = 12.dp,
                        bottom = 4.dp
                    )
            )
            taskStatus(task.taskCompleted)
        }
    }
}

@Composable
fun taskTitle(title: String) {
    Text(
        text = title,
        maxLines = 1,
        style = textStyleTitle,
        overflow = TextOverflow.Ellipsis,
        modifier = cardTitleModifier
    )
}

@Composable
fun taskContent(content: String?) {
    content?.let {
        Text(
            text = it,
            maxLines = 2,
            style = textStyleContent,
            overflow = TextOverflow.Ellipsis,
            modifier = cardContentModifier
        )
    }
}

@Composable
fun taskStatus(status: Boolean) {
    Text(
        text = textTaskStatus(status),
        style = textStyleStatus,
        modifier = cardStatusModifier
    )
}