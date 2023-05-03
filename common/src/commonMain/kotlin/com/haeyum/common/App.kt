package com.haeyum.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.haeyum.common.components.Header
import com.haeyum.common.components.MainBottomNavigation
import com.haeyum.common.presentation.ScreenState
import com.haeyum.common.presentation.screens.HomeScreen
import com.haeyum.common.presentation.screens.SettingsScreen
import com.haeyum.common.presentation.screens.StopwatchScreen

@Composable
fun App() {
    var screenState by rememberSaveable {
        mutableStateOf(ScreenState.HOME)
    }

    Column(modifier = Modifier.fillMaxSize().background(color = Color(0xFFEFEFEF))) {
        Header(title = screenState.title)

        when (screenState) {
            ScreenState.HOME -> HomeScreen(modifier = Modifier.fillMaxWidth().weight(1f))
            ScreenState.STOPWATCH -> StopwatchScreen(modifier = Modifier.fillMaxWidth().weight(1f))
            ScreenState.SETTINGS -> SettingsScreen(modifier = Modifier.fillMaxWidth().weight(1f))
        }
        MainBottomNavigation(screenState = screenState, onScreenChange = { screenState = it })
    }
}