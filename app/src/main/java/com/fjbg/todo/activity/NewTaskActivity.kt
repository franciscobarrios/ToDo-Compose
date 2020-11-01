package com.fjbg.todo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import com.fjbg.todo.data.Task
import com.fjbg.todo.ui.ToDoTheme
import com.fjbg.todo.ui.saveButton
import com.fjbg.todo.ui.tfTaskTitle

class NewTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoTheme {
                Scaffold(
                    bodyContent = {
                        form(null)
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
fun form(task: Task?) {
    Surface {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            tfTaskTitle("Task title")
            tfTaskTitle("Task content")
            saveButton(
                text = "Save",
                onCLick = {
                    task?.let {
                        saveTask(task = it)
                    }
                }
            )
        }
    }
}

fun saveTask(task: Task) {

}