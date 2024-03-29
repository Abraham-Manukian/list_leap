package dtoSerialization

import kotlinx.serialization.Serializable


@Serializable
data class TaskDTO (
    val id_task: String,
    val id_user: String,
    val id_reminder: String,
    val task_name: String,
    val task_description: String,
    val date_creation: String,
    val hashtag: String,
    val task_type: String,
    val date_completion: String,
    val closed: Boolean,
    val subtasks: Boolean
)
