import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import org.example.project.R

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

@Composable
actual fun getPlatformSpecificImage(resource: String): Painter {
    val resId = when (resource) {
        "my_icon_back" -> R.drawable.icon_back
        "my_icon_next" -> R.drawable.icon_next
        else -> R.drawable.icon_back // Backup option
    }
    return painterResource(id = resId)
}