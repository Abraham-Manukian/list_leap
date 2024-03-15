package ui.todayTaskPanel

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.unit.dp
import dtoSerialization.TaskDTO
import org.jetbrains.compose.resources.Resource
import org.jetbrains.compose.resources.painterResource

@Composable
actual fun TaskItem(task: TaskDTO, onTaskCompletedToggle: (TaskDTO) -> Unit) {
    Row(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Icon(
            imageVector = if task.task_type == "High" {
                R.drawable.red_flag.svg
            }
            if task.task_type == "Medium" {
                /*Todo*/
            }
            if task.task_type == "Low" {
                /*Todo*/
            }
        )

        Icon(
            painter = rememberVectorPainter(),
            contentDescription = null
        )
    }
}
//Флажок для приоритета задачи


}