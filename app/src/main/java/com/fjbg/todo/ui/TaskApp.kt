package com.fjbg.todo.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fjbg.todo.navigation.Action
import com.fjbg.todo.navigation.Destinations.AddNewTask
import com.fjbg.todo.navigation.Destinations.Home
import com.fjbg.todo.navigation.Destinations.SplashScreen
import com.fjbg.todo.navigation.Destinations.TaskDetail
import com.fjbg.todo.ui.main.*
import com.fjbg.todo.ui.theme.ToDoTheme


@Composable
fun TaskApp(
    context: Context,
    viewModel: TaskViewModel
) {
    val navController = rememberNavController()
    val actions = remember(navController) { Action(navController) }

    ToDoTheme {
        NavHost(navController = navController, startDestination = Home) {
            composable(SplashScreen) {
                splashScreen(
                    context = context
                )
            }
            composable(Home) {
                homeView(
                    viewModel = viewModel,
                    newTask = actions.newTask
                )
            }
            composable(AddNewTask) {
                newTask(
                    viewModel = viewModel,
                    goBack = actions.navigateUp
                )
            }
            composable(TaskDetail) {
                detailTask(
                    viewModel = viewModel,
                    goBack = actions.navigateUp
                )
            }
        }
    }
}