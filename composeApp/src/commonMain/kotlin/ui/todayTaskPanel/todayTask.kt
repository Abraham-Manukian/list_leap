package ui.todayTaskPanel

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dtoSerialization.TaskDTO
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalResourceApi::class)
@Composable
fun TaskItem(task: TaskDTO) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Отображаем иконку в зависимости от приоритета задачи
        val imageResource = when (task.task_type) {
            "High" -> R.drawable.ic_blue_flag.svg// Замените на ваш ресурс
            "Medium" -> "drawable/ic_yellow_flag.svg" // Замените на ваш ресурс
            "Low" -> "drawable/ic_blue_flag.svg" // Замените на ваш ресурс
            else -> "drawable/ic_default_flag.svg" // Замените на ваш ресурс
        }

        // Используйте painterResource для загрузки изображения из ресурсов
        val imagePainter = painterResource(imageResource)
        Image(
            painter = imagePainter,
            contentDescription = "Task Priority Icon",
            modifier = Modifier.size(24.dp) // Установите нужный размер
        )

        Spacer(modifier = Modifier.width(16.dp)) // Отступ между иконкой и текстом

        // Отображаем название задачи
        Text(
            text = task.task_name,
            style = MaterialTheme.typography.h6,
            color = Color.Black
        )
    }
}

//Флажок для приоритета задачи