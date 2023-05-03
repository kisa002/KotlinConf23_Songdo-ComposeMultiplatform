package com.haeyum.common.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.haeyum.common.presentation.ScreenState

@Composable
fun MainBottomNavigation(screenState: ScreenState, onScreenChange: (ScreenState) -> Unit) {
    BottomNavigation {
        MainBottomNaivgationItem(
            screenState = ScreenState.HOME,
            currentScreenState = screenState,
            onScreenChange = onScreenChange,
            icon = Icons.Filled.Home,
            label = "Home"
        )

        MainBottomNaivgationItem(
            screenState = ScreenState.STOPWATCH,
            currentScreenState = screenState,
            onScreenChange = onScreenChange,
            icon = Icons.Filled.Notifications,
            label = "Stopwatch"
        )

        MainBottomNaivgationItem(
            screenState = ScreenState.SETTINGS,
            currentScreenState = screenState,
            onScreenChange = onScreenChange,
            icon = Icons.Filled.Settings,
            label = "Settings"
        )
    }
}

@Composable
private fun RowScope.MainBottomNaivgationItem(
    screenState: ScreenState,
    currentScreenState: ScreenState,
    onScreenChange: (ScreenState) -> Unit,
    icon: ImageVector,
    label: String
) {
    BottomNavigationItem(
        selected = screenState == currentScreenState,
        onClick = { onScreenChange(screenState) },
        icon = {
            Icon(icon, contentDescription = screenState.title)
        },
        label = {
            Text(label)
        }
    )
}