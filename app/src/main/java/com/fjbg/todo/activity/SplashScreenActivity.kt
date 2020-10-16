package com.fjbg.todo.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import com.fjbg.todo.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppName(name = resources.getString(R.string.app_name))
        }

        GlobalScope.launch {
            delay(2000)
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            Log.d("TAG", "onCreate: ")
            startActivity(intent)
        }
    }
}

@Composable
fun AppName(name: String) {
    Text(text = "Hello $name!")
}
