package com.haeyum.common.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun PangmooTheme(content: @Composable () -> Unit) {
    MaterialTheme(colors = LightColors, content = content)
}