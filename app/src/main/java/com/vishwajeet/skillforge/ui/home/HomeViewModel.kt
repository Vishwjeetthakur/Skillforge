package com.vishwajeet.skillforge.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vishwajeet.skillforge.data.api.RetrofitInstance
import com.vishwajeet.skillforge.data.repository.CourseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val api = RetrofitInstance.api
    private val repository = CourseRepository(api)

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)

    val uiState: StateFlow<UiState> = _uiState

    init {
        loadCourses()
    }

    private fun loadCourses() {

        viewModelScope.launch {
            try {
                val response = repository.getCourses()
                _uiState.value = UiState.Success(response.categories)
            }catch (e: Exception) {
                _uiState.value = UiState.Error(e.localizedMessage ?: "Unknown Error Occurred")
            }
        }

    }
}