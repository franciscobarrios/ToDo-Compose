package com.fjbg.todo.ui.splashscreen

import android.content.Context
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.fjbg.todo.R
import com.fjbg.todo.ui.splashScreenText

@Composable
fun SplashScreen(context: Context) {
    Scaffold(
        backgroundColor = Color.White,
        bodyContent = {
            splashScreenText(context.resources.getString(R.string.app_name))
        }
    )
}
