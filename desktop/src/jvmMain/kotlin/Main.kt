import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.haeyum.common.App
import com.haeyum.common.presentation.screens.StopwatchScreen
import java.io.File


fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "KotlinConf'23 Stopwatch") {
        App()
//        Row(modifier = Modifier.fillMaxSize().background(Color.White)) {
//            var isExpanded by remember { mutableStateOf(false) }
//
//            NavigationContainer(isExpanded = isExpanded, onCollapsed = {
//                isExpanded = false
//            })
//
//            Column(modifier = Modifier.fillMaxSize()) {
//                Header(isExpanded = isExpanded, onCollapsed = {
//                    isExpanded = true
//                })
//
//                when (isExpanded) {
//                    true -> SettingsScreen()
//                    false -> StopwatchScreen()
//                }
//            }
//        }
    }
}

@Composable
fun SettingsScreen() {
    var value by remember { mutableStateOf(0f) }
    Column {
        Text("Setting!", fontSize = 30.sp)
        Text("Volume: $value")
        Slider(value = value, onValueChange = {
            value = it
        })
    }
}
