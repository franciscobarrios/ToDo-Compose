package com.fjbg.todo.ui.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/* Text styles */
val textStyleTopMessage = TextStyle(
    fontFamily = FontFamily.Serif,
    fontSize = 28.sp,
    fontStyle = FontStyle.Normal,
    color = secondaryText,
    textAlign = TextAlign.Start
)

val textStyleDate = TextStyle(
    fontFamily = FontFamily.Serif,
    fontSize = 14.sp,
    fontStyle = FontStyle.Normal,
    color = secondaryText,
    textAlign = TextAlign.Start
)

val textStyleTitle = TextStyle(
    fontFamily = FontFamily.Serif,
    fontSize = 18.sp,
    color = darkGrey,
    textAlign = TextAlign.Start
)

val textStylePlaceHolder = TextStyle(
    fontFamily = FontFamily.Serif,
    fontSize = 18.sp,
    color = secondaryDark,
    textAlign = TextAlign.Start
)

val textStyleContent = TextStyle(
    fontFamily = FontFamily.Serif,
    fontSize = 12.sp,
    color = secondaryText,
    textAlign = TextAlign.Start
)

val textStyleStatus = TextStyle(
    fontFamily = FontFamily.Serif,
    fontSize = 12.sp,
    color = secondaryText,
    textAlign = TextAlign.End
)

val textStyleSmall = TextStyle(
    fontFamily = FontFamily.Serif,
    fontSize = 10.sp,
    color = secondaryText,
    textAlign = TextAlign.End
)

/* Card styles */
val cardTitleModifier = Modifier
    .padding(
        top = 12.dp,
        bottom = 2.dp,
        start = 12.dp,
        end = 12.dp
    )

val cardContentModifier = Modifier
    .padding(
        top = 12.dp,
        bottom = 2.dp,
        start = 12.dp,
        end = 12.dp
    )

val cardStatusModifier = Modifier
    .padding(
        top = 2.dp,
        bottom = 4.dp,
        start = 12.dp,
        end = 12.dp
    )