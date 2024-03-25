import androidx.compose.ui.graphics.painter.Painter
import dtoSerialization.TaskDTO

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = JVMPlatform()

actual fun getPlatformSpecificImage(resource: String): Painter =
    // Здесь должна быть реализация загрузки изображения для Desktop
    Unit

actual fun TaskItem(
    task: TaskDTO,
    onTaskCompletedToggle: (TaskDTO) -> Unit
) {
}