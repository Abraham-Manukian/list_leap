package ui

import dtoSerialization.TaskDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import requestsServer.fetchTasks

class TasksRepository {
    private val _tasks = MutableStateFlow<List<TaskDTO>>(emptyList())
    val tasks: StateFlow<List<TaskDTO>> = _tasks

    fun loadTasks() {
        CoroutineScope(Dispatchers.Main).launch {
            val fetchedTasks = fetchTasks() ?: emptyList()
            _tasks.value = fetchedTasks
        }
    }
}