package com.fjbg.todo.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.setContent
import com.fjbg.todo.ui.theme.ToDoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailTaskActivity : AppCompatActivity() {

    private val viewModel: DetailTaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoTheme {
                viewModel.getTaskDetail(1)
                viewModel.observeTaskDetail().observeAsState().value.let { task ->
                    task?.let { DetailTask(it) }
                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
