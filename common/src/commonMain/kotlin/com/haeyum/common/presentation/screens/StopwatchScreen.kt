package com.haeyum.common.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haeyum.common.components.PrimaryButton
import com.haeyum.common.components.SecondaryButton
import com.haeyum.common.supports.StopwatchStateValue
import com.haeyum.common.supports.rememberStopwatchState

@Composable
fun StopwatchScreen() {
    val stopwatchState by rememberStopwatchState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(vertical = 32.dp),
    ) {
        ActionButtons(
            stopwatchStateValue = stopwatchState.stateValue,
            formattedTimeString = stopwatchState.formattedTimeString,
            onStart = stopwatchState::start,
            onPause = stopwatchState::pause,
            onResume = stopwatchState::resume,
            onReset = stopwatchState::reset,
            onLab = { /*TODO*/ }
        )
    }

    DisposableEffect(Unit) {
        onDispose {
            stopwatchState.stop()
        }
    }
}

@Composable
private fun ActionButtons(
    stopwatchStateValue: StopwatchStateValue,
    formattedTimeString: String,
    onStart: () -> Unit,
    onPause: () -> Unit,
    onResume: () -> Unit,
    onReset: () -> Unit,
    onLab: () -> Unit
) {
    Text(
        text = formattedTimeString,
        modifier = Modifier.padding(32.dp),
        fontSize = 60.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.End
    )

    Column(modifier = Modifier.padding(vertical = 32.dp)) {
        when (stopwatchStateValue) {
            StopwatchStateValue.START -> {
                PrimaryButton(text = "Pause", onClick = onPause)
                SecondaryButton(text = "Lab", onClick = onLab)
            }

            StopwatchStateValue.PAUSE -> {
                PrimaryButton(text = "Resume", onClick = onResume)
                SecondaryButton(text = "Reset", onClick = onReset)
            }

            StopwatchStateValue.STOP -> {
                PrimaryButton(text = "Start", onClick = onStart)
                SecondaryButton(text = "Lab", enabled = false, onClick = onLab)
            }
        }
    }
}