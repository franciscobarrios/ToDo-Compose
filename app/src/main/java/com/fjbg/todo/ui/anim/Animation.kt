package com.fjbg.todo.ui.anim

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