
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import dtoSerialization.TaskDTO
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.util.InternalAPI
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.ExperimentalResourceApi


@OptIn(ExperimentalResourceApi::class)
private val DarkTheme = Color(color = 0xff040B18)

@Composable
expect fun getPlatformSpecificImage(resource: String): Painter



@Composable
fun App() {
    val mainButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = Color(color = 0xffffffff),
    )

    MaterialTheme () {
        Box(Modifier.fillMaxSize().background(DarkTheme))
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    )
    {
        ui.MainScreenTopBar()
        ui.OverdueTaskPanel()
        ui.TodayTasksPanel()

    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    )
    {
        ui.ButtonAdd()
    }

}



suspend fun fetchTasks(): List<TaskDTO> {
    try {
        val response: HttpResponse = httpClient.get("http://10.0.2.2:8080/tasks")
        if (response.status == HttpStatusCode.OK) {
            return Json.decodeFromString(response.bodyAsText())
        } else {
            throw Exception("Failed to fetch tasks: ${response.status}, ${response.bodyAsText()}")
        }
    } catch (e: Exception) {
        e.printStackTrace() // Вывести подробности ошибки
        throw e
    }
}

@OptIn(InternalAPI::class)
suspend fun addTask(task: TaskDTO) {
    httpClient.post("http://10.0.2.2:8080/api/tasks") {
        contentType(ContentType.Application.Json)
        body = task
    }
}

fun getCurrentDate(): String {
    val currentMoment = Clock.System.now()
    val dateTime = currentMoment.toLocalDateTime(TimeZone.currentSystemDefault())
    return "${dateTime.dayOfMonth}.${dateTime.monthNumber}.${dateTime.year}"
}