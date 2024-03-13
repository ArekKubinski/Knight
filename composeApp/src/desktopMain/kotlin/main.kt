import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

object MainKt {
    @JvmStatic
    fun main(args: Array<String>) = application {
        Window(onCloseRequest = ::exitApplication, title = "Knight") {
            App()
        }
    }
}