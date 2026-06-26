package com.vishwajeet.skillforge.navigation


import androidx.lifecycle.ViewModel
import com.vishwajeet.skillforge.data.model.Course
import com.vishwajeet.skillforge.data.model.Lesson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SharedNavigationViewModel : ViewModel() {
    private val _selectedCourse = MutableStateFlow<Course?>(null)
    val selectedCourse: StateFlow<Course?> = _selectedCourse

    private val _selectedLesson = MutableStateFlow<Lesson?>(null)
    val selectedLesson: StateFlow<Lesson?> = _selectedLesson

    fun selectCourse(course: Course) {
        _selectedCourse.value = course
    }

    fun selectLesson(lesson: Lesson) {
        _selectedLesson.value = lesson
    }
}