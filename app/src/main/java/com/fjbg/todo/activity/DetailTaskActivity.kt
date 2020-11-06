package com.fjbg.todo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import com.fjbg.todo.data.Task
import com.fjbg.todo.ui.*

class DetailTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoTheme {
                Scaffold(
                    bodyContent = {
                        detailTask(null)
                    }
                )
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}

@Composable
fun detailTask(task: Task?) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Title",
            style = textStyleTitle
        )
        task?.taskTitle?.let {
            Text(
                text = it,
                style = textStyleTitle
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Text(
            text = "Content",
            style = textStyleContent
        )
        task?.taskContent?.let {
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
            text = task?.taskCompleted?.let { textTaskStatus(it) }.toString(),
            style = textStyleStatus
        )
    }
}