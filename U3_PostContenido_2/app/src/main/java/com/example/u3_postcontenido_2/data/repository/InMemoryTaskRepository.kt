package com.example.u3_postcontenido_2.data.repository

import com.example.u3_postcontenido_2.domain.model.Task
import com.example.u3_postcontenido_2.domain.repository.TaskRepository
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

// data/repository/InMemoryTaskRepository.kt
class InMemoryTaskRepository : TaskRepository {

    private val mutex = Mutex()

    private val tasks = mutableListOf(
        Task(1, "Estudiar Clean Architecture"),
        Task(2, "Implementar Use Cases en la capa Domain"),
        Task(3, "Migrar de Hilt a Koin"),
        Task(4, "Leer documentación de Koin DSL", completed = true),
        Task(5, "Escribir test unitario del Use Case")
    )


    private var nextId = tasks.maxOfOrNull { it.id }?.plus(1) ?: 1L

    override suspend fun getAllTasks(): List<Task> = mutex.withLock {
        tasks.toList() // Return a snapshot
    }

    override suspend fun addTask(title: String) = mutex.withLock {
        val newTask = Task(
            id = nextId++,
            title = title,
            completed = false
        )
        tasks.add(newTask)
    }
}