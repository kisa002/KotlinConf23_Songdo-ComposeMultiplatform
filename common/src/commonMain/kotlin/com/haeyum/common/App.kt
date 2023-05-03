package com.haeyum.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.haeyum.common.components.Header
import com.haeyum.common.components.MainBottomNavigation
import com.haeyum.common.presentation.screens.HomeScreen
import com.haeyum.common.presentation.screens.SettingsScreen
import com.haeyum.common.presentation.screens.StopwatchScreen

@Composable
fun App() {
    Column(modifier = Modifier.fillMaxSize().background(color = Color(0xFFEFEFEF))) {
        Header(title = "Stopwatch")
        HomeScreen(modifier = Modifier.fillMaxWidth().weight(1f))
//        StopwatchScreen(modifier = Modifier.fillMaxWidth().weight(1f))
//        SettingsScreen(modifier = Modifier.fillMaxWidth().weight(1f))
        MainBottomNavigation()
    }
}