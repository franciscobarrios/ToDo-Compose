package com.fjbg.todo.ui.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.fjbg.todo.ui.theme.purple500

@Composable
fun defaultContentView(
    title: String,
    action: () -> Unit,
    goBack: (() -> Unit)?,
    content: @Composable (PaddingValues) -> Unit,
    showBottomBar: Boolean
) {
    Scaffold(
        backgroundColor = Color.White,
        topBar = {
            when (goBack) {
                null -> topBarHome(title = title)
                else -> topBar(title = title, goBack = goBack)
            }
        },
        bodyContent = content,
        floatingActionButton = {
            if (showBottomBar) {
                FloatingActionButton(
                    onClick = action,
                    icon = { Icon(asset = Icons.Default.Add) }
                )
            }
        },
        isFloatingActionButtonDocked = showBottomBar,
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            if (showBottomBar) {
                BottomAppBar(
                    backgroundColor = purple500,
                    cutoutShape = CircleShape,
                    content = {}
                )
            }
        }
    )
}

@Composable
fun topBarHome(
    title: String
) {
    TopAppBar(
        title = { Text(text = title, color = Color.White) },
        backgroundColor = purple500
    )
}

@Composable
fun topBar(
    title: String,
    goBack: () -> Unit
) {
    TopAppBar(
        title = { Text(text = title, color = Color.White) },
        backgroundColor = purple500,
        navigationIcon = {
            IconButton(onClick = goBack) {
                Icon(asset = Icons.Filled.ArrowBack, tint = Color.White)
            }
        }
    )
}