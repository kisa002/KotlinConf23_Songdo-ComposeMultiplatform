package com.haeyum.common.presentation.screens

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.haeyum.common.theme.KawaiBlue

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition()
    val animateBackgroundColor by infiniteTransition.animateColor(
        initialValue = Color(0xFF8E2DE2),
        targetValue = KawaiBlue,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000, easing = { fraction ->
                0.5f * (1 - Math.cos(Math.PI * fraction)).toFloat()
            }),
            repeatMode = RepeatMode.Reverse
        )
    )

    Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
        Text(
            text = "KotlinConf'23 Global in Songdo",
            modifier = Modifier
                .fillMaxWidth(.7f)
                .align(Alignment.CenterHorizontally)
                .background(color = animateBackgroundColor, shape = MaterialTheme.shapes.medium)
                .padding(24.dp),
            style = MaterialTheme.typography.h4.copy(color = Color.White),
            textAlign = TextAlign.Center
        )
    }
}