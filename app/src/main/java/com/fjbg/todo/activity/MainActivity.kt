package com.fjbg.todo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
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

        //val taskId: Int,
        //    val taskTitle: String,
        //    val taskContent: String?,
        //    val taskCompleted: Boolean


    }
}

fun fakeData(): ArrayList<Task> {
    val task = Task(
        taskId = 0,
        taskTitle = "this is a task",
        taskContent = "this is the content of the task",
        taskCompleted = false
    )

    val list = ArrayList<Task>()
    list.add(task)
    list.add(task)
    list.add(task)
    list.add(task)
    list.add(task)

    return list
}

@Composable
fun LazyColumnIndexed(tasks: List<Task>) {
    LazyColumnForIndexed(items = tasks) { index, item ->
        Text(text = item.taskTitle)
        item.taskContent?.let { Text(text = it) }
    }
}