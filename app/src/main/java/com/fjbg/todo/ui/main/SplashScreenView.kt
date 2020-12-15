package com.fjbg.todo.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ContextAmbient
import com.fjbg.todo.R
import com.fjbg.todo.ui.splashScreenText
import kotlinx.coroutines.delay

private const val SplashWaitTime: Long = 2000

@Composable
fun splashScreen(
    goHome: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        alignment = Alignment.Center
    ) {
        splashScreenText(ContextAmbient.current.resources.getString(R.string.app_name))
        LaunchedEffect(Unit) {
            delay(SplashWaitTime)
            goHome.invoke()
        }
    }
}