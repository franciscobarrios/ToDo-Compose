package com.fjbg.todo.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.ripple.RippleIndication
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.fjbg.todo.model.Task
import com.fjbg.todo.ui.common.defaultContentView
import com.fjbg.todo.ui.textTaskStatus
import com.fjbg.todo.ui.tfTaskTitle
import com.fjbg.todo.ui.theme.*

@Composable
fun homeView(
    viewModel: TaskViewModel,
    newTask: () -> Unit,
    drawerState: BottomDrawerState,
    navigateToTask: (Int) -> Unit,
    title: String,
) {
    viewModel.observeTaskList().observeAsState().value.let { list ->
        defaultContentView(
            title = title,
            action = newTask,
            drawerState = drawerState,
            goBack = null,
            showBottomBar = true,
            content = {
                drawer(
                    drawerState = drawerState, content = {
                        contentMain(
                            list = list,
                            navigateToTask = navigateToTask
                        )
                    })
            }
        )
    }
}

@Composable
fun contentMain(
    list: List<Task>?,
    navigateToTask: (Int) -> Unit
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Column {
            greetings(userName = "Fran")
            date()
            if (list != null) {
                when {
                    list.isEmpty() -> emptyList()
                    else -> lazyColumn(
                        list = list,
                        navigateToTask = navigateToTask
                    )
                }
            }
        }
    }
}

@Composable
fun lazyColumn(
    list: List<Task>,
    navigateToTask: (Int) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize().padding(12.dp)
    ) {
        LazyColumnFor(
            items = list
        ) { item ->
            createTaskCard(
                task = item,
                navigateToTask = navigateToTask
            )
        }
    }
}

@Composable
fun drawer(
    drawerState: BottomDrawerState,
    content: @Composable () -> Unit,
) {
    BottomDrawerLayout(
        gesturesEnabled = true,
        drawerState = drawerState,
        bodyContent = content,
        drawerBackgroundColor = white,
        drawerElevation = 8.dp,
        drawerContentColor = primaryDark,
        drawerShape = RoundedCornerShape(
            topLeft = corner_radius, topRight = corner_radius
        ),
        drawerContent = {
            bottomDrawerContent()
        }
    )
}

@Composable
fun bottomDrawerContent() {
    Box(
        modifier = Modifier.padding(
            top = 20.dp, end = 12.dp, start = 12.dp
        ).background(white)
    ) {
        Column {
            Text(
                text = "Set your name",
                style = textStyleTitle,
                modifier = Modifier.padding(8.dp)
            )
            Spacer(modifier = Modifier.padding(12.dp))
            val title = tfTaskTitle("John Doe")
        }
    }
}

@Composable
fun greetings(userName: String) {
    Text(
        text = "Hey $userName,\nthis is your to-do list",
        style = textStyleTopMessage,
        modifier = Modifier.padding(12.dp)
    )
}

@Composable
fun date() {
    Box(
        modifier = Modifier.clickable(onClick = { /*TODO: open calendar*/ }).padding(12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(asset = Icons.Outlined.DateRange, modifier = Modifier.padding(end = 4.dp))
            Text(text = "Today is Dec. 12th", style = textStyleDate)
        }
    }
}

@Composable
fun emptyList() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "No task to show",
            textAlign = TextAlign.Center,
            color = secondaryText
        )
    }
}

@Composable
fun createTaskCard(
    task: Task,
    navigateToTask: (Int) -> Unit
) {
    RippleIndication(
        bounded = true
    )
    Card(
        shape = RoundedCornerShape(corner_radius),
        elevation = 4.dp,
        backgroundColor = almostWhite,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 12.dp)
            .clickable(onClick = { navigateToTask(task.taskId) })
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

