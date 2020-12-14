package com.fjbg.todo.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ContextAmbient
import com.fjbg.todo.R
import com.fjbg.todo.ui.anim.showIntroAnimation
import com.fjbg.todo.ui.splashScreenText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun splashScreen(
    goHome: () -> Unit
) {
    //TODO: implement splashscreen as in Crane app: https://github.com/android/compose-samples/blob/main/Crane/app/src/main/java/androidx/compose/samples/crane/home/LandingScreen.kt
    
    Scaffold(
        backgroundColor = Color.White,
        bodyContent = {
            Column {
                showIntroAnimation()
                splashScreenText(ContextAmbient.current.resources.getString(R.string.app_name))

                GlobalScope.launch(Dispatchers.Main) {
                    delay(2000)
                    goHome.invoke()
                }

            }
        }
    )
}