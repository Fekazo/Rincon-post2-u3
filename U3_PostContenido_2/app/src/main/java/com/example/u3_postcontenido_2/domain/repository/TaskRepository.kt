package com.example.u3_postcontenido_2.domain.repository

import com.example.u3_postcontenido_2.domain.model.Task

// domain/TaskRepository.kt — Contrato de acceso a datos
interface TaskRepository {
    suspend fun getAllTasks(): List<Task>
    suspend fun addTask(title: String): Boolean
}