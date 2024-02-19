import androidx.compose.ui.graphics.painter.Painter
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

actual fun getPlatformSpecificImage(resource: String): Painter {
    // Реализация загрузки изображения для iOS
}