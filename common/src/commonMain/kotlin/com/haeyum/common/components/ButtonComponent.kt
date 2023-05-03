package com.haeyum.common.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.haeyum.common.theme.KawaiBlue

@Composable
fun PrimaryButton(text: String, enabled: Boolean = true, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.widthIn(min = 168.dp),
        enabled = enabled,
        contentPadding = PaddingValues(vertical = 12.dp)
    ) {
        Text(text)
    }
}

@Composable
fun SecondaryButton(text: String, enabled: Boolean = true, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick, modifier = Modifier.widthIn(min = 168.dp), colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent, contentColor = KawaiBlue
        ), enabled = enabled, contentPadding = PaddingValues(vertical = 12.dp)
    ) {
        Text(text)
    }
}