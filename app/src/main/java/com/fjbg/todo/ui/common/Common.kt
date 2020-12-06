package com.fjbg.todo.ui.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fjbg.todo.ui.theme.almostWhite
import com.fjbg.todo.ui.theme.primary
import com.fjbg.todo.ui.theme.primaryDark

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
                else -> topBar(
                    title = title,
                    goBack = goBack
                )
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
                    backgroundColor = primary,
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
        backgroundColor = primary
    )
}

@Composable
fun topBar(
    title: String,
    goBack: () -> Unit
) {
    TopAppBar(
        title = { Text(text = title, color = Color.Black) },
        backgroundColor = Color.White,
        elevation = 0.dp,
        navigationIcon = {
            IconButton(onClick = goBack) {
                Icon(asset = Icons.Filled.ArrowBack, tint = Color.Black)
            }
        }
    )
}