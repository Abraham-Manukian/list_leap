package requestsServer

import dtoSerialization.TaskDTO
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import kotlinx.serialization.json.Json

suspend fun fetchTasks(): List<TaskDTO> {
    val response: HttpResponse = httpClient.get("http://10.0.2.2:8080/tasks")
    if (response.status == HttpStatusCode.OK) {
        return Json.decodeFromString(response.bodyAsText())
    } else {
        throw Exception("Failed to fetch tasks: ${response.status}, ${response.bodyAsText()}")
    }
}