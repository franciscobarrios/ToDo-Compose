package com.fjbg.todo.ui.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fjbg.todo.ui.theme.darkGrey
import com.fjbg.todo.ui.theme.grey

val textStyleTitle = TextStyle(
    fontFamily = FontFamily.Monospace,
    fontSize = 18.sp,
    color = darkGrey,
    textAlign = TextAlign.Start
)
val textStyleContent = TextStyle(
    fontFamily = FontFamily.Monospace,
    fontSize = 12.sp,
    color = grey,
    textAlign = TextAlign.Start
)

val textStyleStatus = TextStyle(
    fontFamily = FontFamily.Monospace,
    fontSize = 12.sp,
    color = grey,
    textAlign = TextAlign.End
)

val textStyleSmall = TextStyle(
    fontFamily = FontFamily.Monospace,
    fontSize = 10.sp,
    color = grey,
    textAlign = TextAlign.End
)

val cardTitleModifier = Modifier
    .padding(
        top = 12.dp,
        bottom = 2.dp,
        start = 8.dp,
        end = 8.dp
    )

val cardContentModifier = Modifier
    .padding(
        top = 12.dp,
        bottom = 2.dp,
        start = 8.dp,
        end = 8.dp
    )

val cardStatusModifier = Modifier
    .padding(
        top = 2.dp,
        bottom = 4.dp,
        start = 8.dp,
        end = 8.dp
    )