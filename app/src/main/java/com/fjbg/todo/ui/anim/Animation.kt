package com.fjbg.todo.ui.anim

import androidx.compose.animation.ColorPropKey
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationSpec
import com.airbnb.lottie.compose.rememberLottieAnimationState
import com.fjbg.todo.R
import com.fjbg.todo.ui.theme.primaryDark
import com.fjbg.todo.ui.theme.white

@Composable
fun showIntroAnimation() {
    val animationSpec = remember { LottieAnimationSpec.RawRes(R.raw.todo) }
    val animationState =
        rememberLottieAnimationState(
            autoPlay = true,
            repeatCount = Integer.MAX_VALUE
        )

    LottieAnimation(
        spec = animationSpec,
        animationState = animationState,
        modifier = Modifier.preferredSize(100.dp)
    )
}

val sizeState = FloatPropKey()
val colorState = ColorPropKey()
val alphaState = FloatPropKey()

enum class FabState { Idle, Exploded }
enum class BottomBarState { Show, Hide }

const val animationDuration = 800

fun fabSizeTransitionDefinition(): TransitionDefinition<FabState> {
    return transitionDefinition {
        state(FabState.Idle) {
            this[sizeState] = 58f
            this[colorState] = primaryDark
            this[alphaState] = 1f
        }
        state(FabState.Exploded) {
            this[sizeState] = 2000f
            this[colorState] = white
            this[alphaState] = 0f
        }

        transition(fromState = FabState.Idle, toState = FabState.Exploded) {
            sizeState using keyframes {
                durationMillis = animationDuration
                80f at 0
                35f at 150
                2000f at animationDuration
            }
            colorState using tween(
                durationMillis = animationDuration,
                easing = LinearEasing
            )
        }
    }
}

fun hideBottomBarTransitionDefinition(): TransitionDefinition<BottomBarState> {
    return transitionDefinition {
        state(BottomBarState.Show) {
            this[sizeState] = 42f
            this[colorState] = primaryDark
        }
    }
}