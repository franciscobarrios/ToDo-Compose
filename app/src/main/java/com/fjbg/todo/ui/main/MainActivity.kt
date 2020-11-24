package com.fjbg.todo.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.setContent
import com.fjbg.todo.model.Task
import com.fjbg.todo.ui.theme.ToDoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoTheme {
                viewModel.observeTaskList().observeAsState().value.let { list ->
                    if (list != null) {
                        MainTask(
                            context = this,
                            list = list
                        )
                    }
                }
            }
        }
    }
}

