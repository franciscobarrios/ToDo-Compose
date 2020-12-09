package com.fjbg.todo.ui.common

import android.util.Log
import androidx.compose.animation.transition
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.fjbg.todo.ui.TAG
import com.fjbg.todo.ui.anim.FabColorState
import com.fjbg.todo.ui.anim.FabState
import com.fjbg.todo.ui.anim.colorTransitionDefinition
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
                exploitingFloatingActionButton()
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
fun exploitingFloatingActionButton() {
    val fabState = remember { mutableStateOf(FabState.Idle) }
    val fabColorState = remember { mutableStateOf(FabColorState.IdleColor) }
    transition(
        definition = sizeTransitionDefinition(),
        initState = FabState.Idle,
        toState = FabState.Exploded
    )

    transition(
        definition = colorTransitionDefinition(),
        initState = FabColorState.IdleColor,
        toState = FabColorState.ExplodedColor
    )
    FloatingActionButton(
        backgroundColor = primaryDark,
        icon = { Icon(asset = Icons.Default.Add, tint = almostWhite) },
        onClick = {
            when (fabState.value) {
                FabState.Idle -> fabState.value = FabState.Exploded
                FabState.Exploded -> fabState.value = FabState.Idle
            }

            when (fabColorState.value) {
                FabColorState.IdleColor -> fabColorState.value = FabColorState.ExplodedColor
                FabColorState.ExplodedColor -> fabColorState.value = FabColorState.IdleColor
            }

            Log.d(TAG, "defaultContentView: fabState: ${fabState.value}")
            Log.d(TAG, "defaultContentView: fabColorState: ${fabColorState.value}")
        }
    )
}

@Preview
@Composable
fun exploitingFloatingActionButtonPreview() {
    exploitingFloatingActionButton()
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