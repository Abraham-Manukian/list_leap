import dtoSerialization.TaskDTO

actual fun TaskItem(
    task: TaskDTO,
    onTaskCompletedToggle: (TaskDTO) -> Unit
) {
}