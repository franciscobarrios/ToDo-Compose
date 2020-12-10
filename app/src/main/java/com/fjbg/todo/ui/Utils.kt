package com.fjbg.todo.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
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
import com.fjbg.todo.ui.theme.errorColor
import com.fjbg.todo.ui.theme.textStyleTitle
import com.fjbg.todo.ui.theme.white

const val TAG = ">>>>>>>>>>>>>>>>>>>"

@Composable
fun splashScreenText(appName: String) {
    Box(Modifier.fillMaxSize()) {
        Text(
            text = appName,
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun tfTaskTitle(placeHolder: String): String {
    val textState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        backgroundColor = white,
        modifier = Modifier.fillMaxWidth(),
        errorColor = errorColor,
        shape = CircleShape,
        value = textState.value,
        onValueChange = { textState.value = it },
        placeholder = {
            Text(
                text = placeHolder,
                style = textStyleTitle,
                maxLines = 1
            )
        }
    )
    return if (textState.value.text.isNotEmpty()) textState.value.text else ""
}

@Composable
fun saveButton(text: String, enabled: Boolean, onCLick: () -> Unit) {
    Button(
        enabled = enabled,
        onClick = onCLick,
        shape = CircleShape
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


