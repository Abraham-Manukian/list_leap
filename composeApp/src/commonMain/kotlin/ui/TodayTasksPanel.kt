package ui

import TasksRepository
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TodayTasksPanel(tasksRepository: TasksRepository = remember { TasksRepository() }) {
    // Подписываемся на изменения списка задач
    val tasks by tasksRepository.tasks.collectAsState()

    // Запрашиваем задачи при первом рендеринге компонента
    LaunchedEffect(Unit) {
        tasksRepository.loadTasks()
    }

    LazyColumn {
        items(tasks) { task ->
            Text(text = "Задача: ${task.task_name}",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.padding(16.dp))
        }
    }
}