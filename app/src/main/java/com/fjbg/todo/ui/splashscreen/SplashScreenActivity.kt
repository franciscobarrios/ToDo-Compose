package com.fjbg.todo.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import androidx.compose.ui.platform.setContent
import com.fjbg.todo.R
import com.fjbg.todo.ui.main.MainActivity
import com.fjbg.todo.ui.splashScreenText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = {},
                bodyContent = {
                    splashScreenText(resources.getString(R.string.app_name))
                })
        }
        GlobalScope.launch {
            delay(300)
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }
    }
}
