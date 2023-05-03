import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.haeyum.common.App

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "KotlinConf'23 Stopwatch") {
        App()
    }
}
