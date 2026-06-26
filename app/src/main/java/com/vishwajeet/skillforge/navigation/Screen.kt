package com.vishwajeet.skillforge.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object CourseDetail : Screen("course_detail")
    object Lesson : Screen("lesson")
}