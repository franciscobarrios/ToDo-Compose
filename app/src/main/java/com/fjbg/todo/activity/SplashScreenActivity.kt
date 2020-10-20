package com.fjbg.todo.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import com.fjbg.todo.R
import com.fjbg.todo.ui.Greeting
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppName(name = resources.getString(R.string.app_name))
            Greeting(resources.getString(R.string.app_name))
        }

        GlobalScope.launch {
            delay(2000)
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }
    }
}

@Composable
fun AppName(name: String) {
    Text(text = "Hello $name!")
}
