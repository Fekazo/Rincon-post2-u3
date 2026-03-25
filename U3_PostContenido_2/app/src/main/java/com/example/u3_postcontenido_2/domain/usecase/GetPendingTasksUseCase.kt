package com.example.u3_postcontenido_2.domain.usecase

import com.example.u3_postcontenido_2.domain.model.Task
import com.example.u3_postcontenido_2.domain.repository.TaskRepository

// domain/usecase/GetPendingTasksUseCase.kt — Kotlin puro, sin Android
class GetPendingTasksUseCase(private val repository: TaskRepository) {
    suspend operator fun invoke(): List<Task> {
        return repository.getAllTasks()
            .filter  { !it.completed }        // Solo tareas pendientes
            .sortedByDescending { it.id }     // Más recientes primero
    }
}