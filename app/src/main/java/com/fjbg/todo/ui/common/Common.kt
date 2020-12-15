package com.fjbg.todo.ui.common

import android.util.Log
import androidx.compose.animation.core.TransitionState
import androidx.compose.animation.transition
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fjbg.todo.ui.TAG
import com.fjbg.todo.ui.anim.FabState
import com.fjbg.todo.ui.anim.colorState
import com.fjbg.todo.ui.anim.fabSizeTransitionDefinition
import com.fjbg.todo.ui.anim.sizeState
import com.fjbg.todo.ui.theme.almostWhite
import com.fjbg.todo.ui.theme.primary
import com.fjbg.todo.ui.theme.white

@Composable
fun defaultContentView(
    title: String,
    action: () -> Unit,
    drawerState: BottomDrawerState?,
    goBack: (() -> Unit)?,
    content: @Composable (PaddingValues) -> Unit,
    showBottomBar: Boolean
) {
    Scaffold(
        backgroundColor = white,
        topBar = {
            if (goBack != null) {
                topBar(title = title, goBack = goBack)
            }
        },
        bodyContent = content,
        floatingActionButton = {
            if (showBottomBar) {
                explodingFloatingActionButton(action)
            }
        },
        isFloatingActionButtonDocked = showBottomBar,
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            if (showBottomBar) {
                BottomAppBar(cutoutShape = CircleShape) {
                    IconButton(
                        onClick = {


                            Log.d(TAG, "onClick: ${drawerState?.value}")
                        }) {
                        Icon(Icons.Filled.MoreVert)
                    }
                }
            }
        }
    )
}

@Composable
fun fab(
    fabState: MutableState<FabState>,
    transition: TransitionState
) {
    FloatingActionButton(
        backgroundColor = transition[colorState],
        icon = {
            Icon(
                asset = Icons.Default.Add,
                tint = almostWhite,
            )
        },
        modifier = Modifier.size(transition[sizeState].dp),
        onClick = { fabState.value = FabState.Idle }
    )
}

@Composable
fun explodingFloatingActionButton(action: () -> Unit) {
    val state = remember { mutableStateOf(FabState.Exploded) }
    val transition = transition(
        definition = fabSizeTransitionDefinition(),
        initState = FabState.Idle,
        toState = if (state.value == FabState.Idle) FabState.Exploded else FabState.Idle,
        onStateChangeFinished = { action.invoke() }
    )
    fab(fabState = state, transition = transition)
}

@Composable
fun topBar(
    title: String,
    goBack: () -> Unit
) {
    TopAppBar(
        title = { Text(text = title, color = primary) },
        backgroundColor = white,
        elevation = 0.dp,
        navigationIcon = {
            IconButton(onClick = goBack) {
                Icon(asset = Icons.Filled.ArrowBack, tint = primary)
            }
        }
    )
}