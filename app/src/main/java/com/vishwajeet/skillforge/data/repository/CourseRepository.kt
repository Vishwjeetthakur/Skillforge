package com.vishwajeet.skillforge.data.repository

import com.vishwajeet.skillforge.data.api.ApiService
import com.vishwajeet.skillforge.data.api.RetrofitInstance

class CourseRepository(
    private val api : ApiService
) {

    suspend fun getCourses() = api.getCourses()
}