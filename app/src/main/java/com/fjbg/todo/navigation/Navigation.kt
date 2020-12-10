package com.fjbg.todo.navigation

import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.fjbg.todo.navigation.Destinations.AddNewTask
import com.fjbg.todo.navigation.Destinations.Home
import com.fjbg.todo.navigation.Destinations.Settings
import com.fjbg.todo.navigation.Destinations.TaskDetail

object Destinations {
    const val SplashScreen = "splashScreen"
    const val Home = "home"
    const val Settings = "settings"
    const val AddNewTask = "addProject"
    const val TaskDetail = "taskDetail"

    object TaskDetailArgs {
        const val TaskId = "taskId"
    }
}

class Action(navController: NavHostController) {
    val home: () -> Unit = { navController.navigate(Home) }
    val settings: () -> Unit = { navController.navigate(Settings) }
    val newTask: () -> Unit = { navController.navigate(AddNewTask) }
    val navigateUp: () -> Unit = { navController.popBackStack() }
    val taskDetail: (Int) -> Unit = { taskId ->
        navController.navigate("$TaskDetail/$taskId")
    }
}