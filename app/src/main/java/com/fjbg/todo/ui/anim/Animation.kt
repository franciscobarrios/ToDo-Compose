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
import com.fjbg.todo.ui.theme.almostWhite
import com.fjbg.todo.ui.theme.primaryDark

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

enum class FabState {
    Idle, Exploded, IdleColor, ExplodedColor
}

fun sizeTransitionDefinition(): TransitionDefinition<FabState> {
    return transitionDefinition {
        state(FabState.Idle) { this[sizeState] = 80f }
        state(FabState.Exploded) { this[sizeState] = 4000f }
        state(FabState.IdleColor) { this[colorState] = primaryDark }
        state(FabState.ExplodedColor) { this[colorState] = almostWhite }

        transition(fromState = FabState.Idle, toState = FabState.Exploded) {
            sizeState using keyframes {
                durationMillis = 900
                80f at 0
                35f at 150
                4000f at 900
            }
        }
    }
}