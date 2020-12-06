package com.fjbg.todo.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(

)

//primary: Color = Color(0xFFBB86FC),
//    primaryVariant: Color = Color(0xFF3700B3),
//    secondary: Color = Color(0xFF03DAC6),
//    background: Color = Color(0xFF121212),
//    surface: Color = Color(0xFF121212),
//    error: Color = Color(0xFFCF6679),
//    onPrimary: Color = Color.Black,
//    onSecondary: Color = Color.Black,
//    onBackground: Color = Color.White,
//    onSurface: Color = Color.White,
//    onError: Color = Color.Black

private val LightColorPalette = lightColors(
    primary = primary,
    primaryVariant = primaryDark,
    background = almostWhite,
    secondary = secondary
)

@Composable
fun ToDoTheme(
    content: @Composable() () -> Unit
) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = typography,
        shapes = shapes,
        content = content
    )
}