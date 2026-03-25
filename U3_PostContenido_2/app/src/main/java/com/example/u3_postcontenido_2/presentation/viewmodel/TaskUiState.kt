// presentation/viewmodel/TaskUiState.kt
package com.example.u3_postcontenido_2.presentation.viewmodel

import com.example.u3_postcontenido_2.domain.model.Task

sealed class TaskUiState {
    object Loading : TaskUiState()
    data class Success(val tasks: List<Task>) : TaskUiState()
    data class Error(val message: String) : TaskUiState()
}