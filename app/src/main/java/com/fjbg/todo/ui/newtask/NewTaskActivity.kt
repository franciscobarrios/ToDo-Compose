package com.fjbg.todo.ui.newtask

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.fjbg.todo.ui.theme.ToDoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewTaskActivity : AppCompatActivity() {

    val viewModel: NewTaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoTheme {
                NewTask(viewModel = viewModel)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}