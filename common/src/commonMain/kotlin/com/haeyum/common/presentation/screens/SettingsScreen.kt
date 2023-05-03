package com.haeyum.common.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.haeyum.common.getVersionName

@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
    var value by remember { mutableStateOf(0f) }
    var checked by remember { mutableStateOf(false) }

    Column(modifier = modifier.padding(24.dp)) {
        SomethingValue(value = value, onValueChange = { value = it })
        SomethingSwitch(checked = checked, onCheckedChange = { checked = it })
        Spacer(modifier = Modifier.weight(1f))
        VersionText(version = getVersionName())
    }
}

@Composable
private fun SomethingValue(value: Float, onValueChange: (Float) -> Unit) {
    Column {
        Text(text = "Something Value", style = MaterialTheme.typography.subtitle1)
        Slider(value = value, onValueChange = onValueChange)
    }
}

@Composable
private fun SomethingSwitch(checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Something Switch", style = MaterialTheme.typography.subtitle1)
        Switch(checked = checked, onCheckedChange = onCheckedChange)
    }
}

@Composable
private fun VersionText(version: String) {
    Text(
        text = "Version $version",
        modifier = Modifier.fillMaxWidth(),
        style = MaterialTheme.typography.subtitle1,
        textAlign = TextAlign.Center
    )
}