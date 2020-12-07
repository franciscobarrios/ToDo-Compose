package com.fjbg.todo.ui.common

import androidx.compose.animation.transition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fjbg.todo.ui.anim.FabState
import com.fjbg.todo.ui.anim.sizeState
import com.fjbg.todo.ui.anim.sizeTransitionDefinition
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
        backgroundColor = almostWhite,
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
                val fabState = remember { mutableStateOf(FabState.Idle) }
                FloatingActionButton(
                    onClick = {
                        if (fabState.value == FabState.Idle) fabState.value =
                            FabState.Exploded else fabState.value = FabState.Idle
                    },
                    backgroundColor = primaryDark,
                    icon = { Icon(asset = Icons.Default.Add, tint = almostWhite) }
                )

                val state = transition(
                    definition = sizeTransitionDefinition(),
                    toState = fabState.value
                )

                Canvas(modifier = Modifier.preferredSize(80.dp)) {
                    drawCircle(Color.Red, state[sizeState])
                }
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
        title = { Text(text = title, color = almostWhite) },
        backgroundColor = primary
    )
}

@Composable
fun topBar(
    title: String,
    goBack: () -> Unit
) {
    TopAppBar(
        title = { Text(text = title, color = primary) },
        backgroundColor = almostWhite,
        elevation = 0.dp,
        navigationIcon = {
            IconButton(onClick = goBack) {
                Icon(asset = Icons.Filled.ArrowBack, tint = primary)
            }
        }
    )
}