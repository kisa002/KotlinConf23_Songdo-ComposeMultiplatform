package com.haeyum.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(title: String) {
    Row(
        modifier = Modifier.fillMaxWidth().heightIn(min = 64.dp).background(Color.White).drawBehind {
            drawLine(
                color = Color.Gray,
                start = Offset(0f, size.height),
                end = Offset(x = size.width, y = size.height),
                strokeWidth = 1f
            )
        }.padding(8.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title, modifier = Modifier.padding(start = 8.dp), fontSize = 24.sp, fontWeight = FontWeight.Bold
        )
    }
}