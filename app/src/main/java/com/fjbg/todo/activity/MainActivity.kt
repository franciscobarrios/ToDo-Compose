package com.fjbg.todo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fjbg.todo.R
import com.fjbg.todo.data.Task
import com.fjbg.todo.ui.Greeting
import com.fjbg.todo.ui.ToDoTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(resources.getString(R.string.app_name))
                }
                LazyColumnIndexed(fakeData())
            }
        }
    }
}

fun fakeData(): ArrayList<Task> {
    val task = Task(
        taskId = 0,
        taskTitle = "This is a task",
        taskContent = "this is the content of the task",
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

fun mod(): Modifier {
    return Modifier.padding(
        start = 12.dp,
        top = 36.dp,
        end = 12.dp,
        bottom = 12.dp
    )
}

@Composable
fun LazyColumnIndexed(tasks: List<Task>) {
    LazyColumnFor(
        items = tasks,
        modifier = mod()
    ) { item ->
        Text(
            text = item.taskTitle,
            style = TextStyle(
                fontFamily = FontFamily.Monospace,
                fontSize = 18.sp,
                color = Color.DarkGray
            )
        )
        item.taskContent?.let {
            Text(
                text = it,
                style = TextStyle(
                    fontFamily = FontFamily.Monospace,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            )
        }
        Text(
            text = taskStatus(item.taskCompleted),
            style = TextStyle(
                fontFamily = FontFamily.Monospace,
                fontSize = 12.sp,
                color = Color.Gray
            )
        )
    }
}

fun taskStatus(status: Boolean): String {
    return if (status) {
        "Completed"
    } else {
        "Uncompleted"
    }
}