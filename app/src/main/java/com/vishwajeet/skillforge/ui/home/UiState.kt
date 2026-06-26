package com.vishwajeet.skillforge.ui.home

import com.vishwajeet.skillforge.data.model.Category

sealed interface UiState {

    object Loading : UiState
    data class Success(val categories: List<Category>) : UiState
    data class Error(val message: String) : UiState
}