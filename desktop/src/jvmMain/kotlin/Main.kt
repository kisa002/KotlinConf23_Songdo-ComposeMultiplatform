import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.haeyum.common.App
import com.haeyum.common.AppViewModel
import com.haeyum.common.supports.StopwatchUtil

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "KotlinConf'23 Stopwatch") {
        val viewModel = remember {
            AppViewModel(StopwatchUtil())
        }
        App(viewModel = viewModel)

        DisposableEffect(Unit) {
            onDispose {
                viewModel.destroy()
            }
        }
    }
}
