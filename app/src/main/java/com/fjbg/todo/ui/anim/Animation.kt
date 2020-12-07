package com.fjbg.todo.ui.anim

import androidx.compose.animation.core.FloatPropKey
import androidx.compose.animation.core.TransitionDefinition
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.transitionDefinition
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationSpec
import com.airbnb.lottie.compose.rememberLottieAnimationState
import com.fjbg.todo.R

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

enum class FabState {
    Idle, Exploded
}

fun sizeTransitionDefinition(): TransitionDefinition<FabState> {
    return transitionDefinition {
        state(FabState.Idle) { this[sizeState] = 80f }
        state(FabState.Exploded) { this[sizeState] = 4000f }

        transition(fromState = FabState.Idle, toState = FabState.Exploded) {
            sizeState using keyframes {
                durationMillis = 700
                80f at 0
                35f at 120
                4000f at 700
            }
        }
    }
}