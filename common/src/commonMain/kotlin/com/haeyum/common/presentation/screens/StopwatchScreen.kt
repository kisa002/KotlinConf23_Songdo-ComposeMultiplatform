package com.haeyum.common.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haeyum.common.components.PrimaryButton
import com.haeyum.common.components.SecondaryButton
import com.haeyum.common.supports.StopwatchState

@Composable
fun StopwatchScreen(
    modifier: Modifier = Modifier,
    stopwatchState: StopwatchState,
    formattedTimeString: String,
    onStart: () -> Unit,
    onPause: () -> Unit,
    onResume: () -> Unit,
    onReset: () -> Unit
) {
    Column(
        modifier = modifier.padding(vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ActionButtons(
            stopwatchState = stopwatchState,
            formattedTimeString = formattedTimeString,
            onStart = onStart,
            onPause = onPause,
            onResume = onResume,
            onReset = onReset
        )
    }
}

@Composable
private fun ActionButtons(
    stopwatchState: StopwatchState,
    formattedTimeString: String,
    onStart: () -> Unit,
    onPause: () -> Unit,
    onResume: () -> Unit,
    onReset: () -> Unit
) {
    Text(
        text = formattedTimeString,
        modifier = Modifier.padding(32.dp),
        fontSize = 60.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.End
    )

    Column(modifier = Modifier.padding(vertical = 32.dp)) {
        when (stopwatchState) {
            StopwatchState.START -> {
                PrimaryButton(text = "Pause", onClick = onPause)
                SecondaryButton(text = "Reset", enabled = false, onClick = onReset)
            }

            StopwatchState.PAUSE -> {
                PrimaryButton(text = "Resume", onClick = onResume)
                SecondaryButton(text = "Reset", onClick = onReset)
            }

            StopwatchState.STOP -> {
                PrimaryButton(text = "Start", onClick = onStart)
            }
        }
    }
}