package com.haeyum.common.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun PangmooTheme(isSystemInDarkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(colors = if (isSystemInDarkTheme) DarkColors else LightColors, content = content)
}