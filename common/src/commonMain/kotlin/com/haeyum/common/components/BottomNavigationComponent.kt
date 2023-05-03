package com.haeyum.common.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable

@Composable
fun MainBottomNavigation() {
    BottomNavigation {
        BottomNavigationItem(selected = false, onClick = {}, icon = {
            Icon(Icons.Filled.Home, contentDescription = "Home")
        }, label = {
            Text("Home")
        })
        BottomNavigationItem(selected = true, onClick = {}, icon = {
            Icon(Icons.Filled.Notifications, contentDescription = "Stopwatch")
        }, label = {
            Text("Stopwatch")
        })
        BottomNavigationItem(selected = false, onClick = {}, icon = {
            Icon(Icons.Filled.Settings, contentDescription = "Settings")
        }, label = {
            Text("Settings")
        })
    }
}