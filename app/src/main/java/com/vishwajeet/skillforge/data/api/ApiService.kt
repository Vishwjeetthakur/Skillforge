package com.vishwajeet.skillforge.data.api

import com.vishwajeet.skillforge.data.model.ApiResponse
import retrofit2.http.GET

interface ApiService {

    @GET("android-assesment/notes/refs/heads/main/data.json")
    suspend fun getCourses(): ApiResponse


}