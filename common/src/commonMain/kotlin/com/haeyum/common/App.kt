package com.haeyum.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.haeyum.common.components.Header
import com.haeyum.common.components.MainBottomNavigation
import com.haeyum.common.presentation.ScreenState
import com.haeyum.common.presentation.screens.HomeScreen
import com.haeyum.common.presentation.screens.SettingsScreen
import com.haeyum.common.presentation.screens.StopwatchScreen
import com.haeyum.common.supports.StopwatchUtil

@Composable
fun App(viewModel: AppViewModel = AppViewModel(StopwatchUtil())) {
    var screenState by rememberSaveable {
        mutableStateOf(ScreenState.HOME)
    }

    val stopwatchState by viewModel.stopwatchState.collectAsState()
    val formattedTimeString by viewModel.formattedTimeString.collectAsState()

    Column(modifier = Modifier.fillMaxSize().background(color = Color(0xFFEFEFEF))) {
        Header(title = screenState.title)

        when (screenState) {
            ScreenState.HOME -> HomeScreen(modifier = Modifier.fillMaxWidth().weight(1f))
            ScreenState.STOPWATCH -> StopwatchScreen(
                modifier = Modifier.fillMaxWidth().weight(1f),
                stopwatchState = stopwatchState,
                formattedTimeString = formattedTimeString,
                onStart = viewModel::start,
                onPause = viewModel::pause,
                onResume = viewModel::resume,
                onReset = viewModel::reset,
                onLab = {}
            )

            ScreenState.SETTINGS -> SettingsScreen(modifier = Modifier.fillMaxWidth().weight(1f))
        }
        MainBottomNavigation(screenState = screenState, onScreenChange = { screenState = it })
    }
}