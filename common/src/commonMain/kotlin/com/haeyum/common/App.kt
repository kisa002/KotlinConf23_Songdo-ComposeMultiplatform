@file:OptIn(ExperimentalMaterialApi::class)

package com.haeyum.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haeyum.common.supports.StopwatchStateValue
import com.haeyum.common.supports.rememberStopwatchState

@Composable
fun App() {
    Row(modifier = Modifier.fillMaxSize().background(Color.White)) {
        var isExpanded by remember { mutableStateOf(false) }

        NavigationContainer(isExpanded = isExpanded, onCollapsed = {
            isExpanded = false
        })

        Column(modifier = Modifier.fillMaxSize()) {
            Header(isExpanded = isExpanded, onCollapsed = {
                isExpanded = true
            })

            StopwatchScreen()
        }
    }
}

@Composable
private fun StopwatchScreen() {
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
private fun Header(isExpanded: Boolean, onCollapsed: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().heightIn(min = 64.dp).padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AnimatedVisibility(visible = !isExpanded) {
            IconButton(onClick = onCollapsed) {
                Icon(
                    if (isExpanded) Icons.Filled.ArrowBack else Icons.Filled.ArrowForward,
                    contentDescription = if (isExpanded) "Collapse" else "Expand"
                )
            }
        }

        Text(
            text = "Stopwatch",
            modifier = Modifier.padding(start = 8.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
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

@Composable
private fun PrimaryButton(text: String, enabled: Boolean = true, onClick: () -> Unit) {
    Button(
        onClick = onClick, modifier = Modifier.widthIn(min = 168.dp), colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF25AAFF), contentColor = Color.White
        ), enabled = enabled, contentPadding = PaddingValues(vertical = 12.dp)
    ) {
        Text(text)
    }
}

@Composable
private fun SecondaryButton(text: String, enabled: Boolean = true, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick, modifier = Modifier.widthIn(min = 168.dp), colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent, contentColor = Color(0xFF25AAFF)
        ), enabled = enabled, contentPadding = PaddingValues(vertical = 12.dp)
    ) {
        Text(text)
    }
}


@Composable
private fun NavigationContainer(isExpanded: Boolean, onCollapsed: () -> Unit) {
    Row {
        AnimatedVisibility(visible = isExpanded) {
            NavigationRail(
                modifier = Modifier.drawBehind {
                    drawLine(
                        color = Color.LightGray,
                        start = Offset(size.width, 0f),
                        end = Offset(size.width, size.height),
                        strokeWidth = 2f
                    )
                }, elevation = 0.dp
            ) {
                Spacer(modifier = Modifier.height(64.dp))
                NavigationRailItem(selected = false, onClick = {}, icon = {
                    Icon(Icons.Filled.Home, contentDescription = "Home")
                }, label = {
                    Text("Home")
                })
                NavigationRailItem(selected = true, onClick = {}, icon = {
                    Icon(Icons.Filled.Notifications, contentDescription = "Stopwatch")
                }, label = {
                    Text("Stopwatch")
                })
                NavigationRailItem(selected = false, onClick = {}, icon = {
                    Icon(Icons.Filled.Settings, contentDescription = "Settings")
                }, label = {
                    Text("Settings")
                })
                Spacer(modifier = Modifier.weight(1f))
                NavigationRailItem(selected = false, onClick = onCollapsed, icon = {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Collapse Rail")
                })
            }
        }
    }
}
