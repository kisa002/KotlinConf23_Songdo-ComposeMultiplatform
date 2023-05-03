package com.haeyum.common.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val KawaiBlue = Color(0xFF25AAFF)
val KawaiDark = Color(0xFF1E1F22)

val LightColors = lightColors(
    primary = KawaiBlue
)
val DarkColors = darkColors(
    primary = KawaiBlue,
    surface = KawaiDark
)