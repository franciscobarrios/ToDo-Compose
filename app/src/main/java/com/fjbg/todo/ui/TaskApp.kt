package com.fjbg.todo.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fjbg.todo.navigation.Action
import com.fjbg.todo.navigation.Destinations.AddNewTask
import com.fjbg.todo.navigation.Destinations.Home
import com.fjbg.todo.ui.main.MainTask
import com.fjbg.todo.ui.main.NewTask
import com.fjbg.todo.ui.main.TaskViewModel
import com.fjbg.todo.ui.theme.ToDoTheme


@Composable
fun TaskApp(viewModel: TaskViewModel) {
    val navController = rememberNavController()
    val actions = remember(navController) { Action(navController) }

    ToDoTheme {
        NavHost(navController = navController, startDestination = Home) {
            composable(Home) {
                MainTask(
                    viewModel = viewModel,
                    newTask = actions.newTask
                )
            }
            composable(AddNewTask) {
                NewTask(
                    viewModel = viewModel,
                    goBack = actions.navigateUp
                )
            }
        }
    }
}