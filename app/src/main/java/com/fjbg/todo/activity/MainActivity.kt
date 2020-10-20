package com.fjbg.todo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import com.fjbg.todo.R
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
            }
        }
    }
}

