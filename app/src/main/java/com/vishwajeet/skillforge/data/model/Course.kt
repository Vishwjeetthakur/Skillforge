package com.vishwajeet.skillforge.data.model

data class Course(
    val title: String,
    val rating: Double,
    val durationHours: Double,
    val thumbnailUrl: String,
    val level: String,
    val description: String,
    val students: Int,
    val instructor: Instructor,
    val lessons: List<Lesson>
)
