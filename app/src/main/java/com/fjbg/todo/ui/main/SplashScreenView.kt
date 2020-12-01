package com.fjbg.todo.ui.main

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.ui.tooling.preview.Preview
import com.fjbg.todo.R
import com.fjbg.todo.ui.splashScreenText

@Composable
fun splashScreen(context: Context) {
    Scaffold(
        backgroundColor = Color.White,
        bodyContent = {
            splashScreenText(context.resources.getString(R.string.app_name))
        }
    )
}

@Preview
@Composable
fun splashScreenPreview() {
    Scaffold(
        bodyContent = {
            Box(Modifier.fillMaxWidth()) {
                Text(
                    text = "To Do",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    )
}