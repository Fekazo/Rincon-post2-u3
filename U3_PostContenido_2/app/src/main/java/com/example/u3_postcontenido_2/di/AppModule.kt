package com.example.u3_postcontenido_2.di

import com.example.u3_postcontenido_2.data.repository.InMemoryTaskRepository
import com.example.u3_postcontenido_2.domain.repository.TaskRepository
import com.example.u3_postcontenido_2.domain.usecase.GetPendingTasksUseCase
import com.example.u3_postcontenido_2.presentation.viewmodel.TaskViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

// di/AppModule.kt — Módulo Koin (reemplaza los módulos de Hilt)
val appModule = module {
    // Repository: Use singleOf and bind to the Interface
    singleOf(::InMemoryTaskRepository) bind TaskRepository::class

    // Use Case: Use factoryOf (creates a new instance every time)
    factoryOf(::GetPendingTasksUseCase)

    // ViewModel: Use viewModelOf (scoped to the ViewModel lifecycle)
    viewModelOf(::TaskViewModel)
}