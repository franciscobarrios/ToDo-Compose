package com.fjbg.todo.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

const val TAG = ">>>>>>>>>>>>>>>>>>>"

@Composable
fun splashScreenText(appName: String) {
    Box(Modifier.fillMaxSize()) {
        Text(text = appName,
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun tfTaskTitle(placeHolder: String): String {
    val textState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        placeholder = {
            Text(
                text = placeHolder,
                maxLines = 1
            )
        }
    )
    Spacer(modifier = Modifier.padding(12.dp))
    return textState.value.text
}

@Composable
fun saveButton(text: String, onCLick: () -> Unit) {
    Button(
        onClick = onCLick,
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = text,
            maxLines = 1,
            modifier = Modifier.padding(8.dp)
        )
    }
}

fun textTaskStatus(status: Boolean): String {
    return if (status) {
        "Completed"
    } else {
        "Uncompleted"
    }
}


