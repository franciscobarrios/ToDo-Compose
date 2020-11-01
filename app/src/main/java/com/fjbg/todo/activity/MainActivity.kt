package com.fjbg.todo.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.ripple.RippleIndication
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.fjbg.todo.data.Task
import com.fjbg.todo.ui.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoTheme {
                Scaffold(
                    bodyContent = {
                        LazyColumn(this, fakeData())
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                startActivity(Intent(this, NewTaskActivity::class.java))
                            }
                        ) {
                            Icon(asset = Icons.Default.Add)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun LazyColumn(context: Context, tasks: List<Task>) {
    LazyColumnFor(
        items = tasks,
        modifier = Modifier.padding(
            start = 8.dp,
            top = 12.dp,
            end = 8.dp,
            bottom = 12.dp
        )
    ) { item ->
        createTaskCard(
            context = context,
            task = item
        )
    }
}


@Composable
fun createTaskCard(context: Context, task: Task) {
    RippleIndication(
        bounded = true
    )
    Card(
        shape = shapes.small,
        elevation = 2.dp,
        backgroundColor = almostWhite,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = {
                val i = Intent(context, DetailTaskActivity::class.java)
                i.putExtra("taskId", task.taskId)
                context.startActivity(i)
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

fun fakeData(): ArrayList<Task> {
    val task = Task(
        taskId = 0,
        taskTitle = "This is a task",
        taskContent = "this is the content of the task, this is the content of the task, this is the content of the task, this is the content of the task, this is the content of the task",
        taskCompleted = false
    )

    val list = ArrayList<Task>()
    list.add(task)
    list.add(task)
    list.add(task)
    list.add(task)
    list.add(task)
    list.add(task)
    list.add(task)
    list.add(task)
    list.add(task)
    list.add(task)
    list.add(task)
    list.add(task)
    list.add(task)
    list.add(task)
    list.add(task)
    list.add(task)
    list.add(task)
    list.add(task)
    list.add(task)
    list.add(task)
    list.add(task)
    list.add(task)
    return list
}