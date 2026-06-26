package com.vishwajeet.skillforge.data.repository

import com.vishwajeet.skillforge.data.api.ApiService
import com.vishwajeet.skillforge.data.model.ApiResponse
import com.vishwajeet.skillforge.data.model.Category
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class CourseRepositoryTest {

    private class FakeSkillforgeApiService(
        private val responseToReturn: ApiResponse
    ) : ApiService {

        override suspend fun getCourses(): ApiResponse {
            return responseToReturn
        }
    }

    @Test
    fun `getCourses returns expected data from apiService successfully`() = runTest {

        val mockApiResponse = ApiResponse(
            categories = listOf(
                Category(
                    name = "Android Development",
                    courses = emptyList()
                ),
                Category(
                    name = "Backend & APIs",
                    courses = emptyList()
                )
            )
        )

        val fakeApi = FakeSkillforgeApiService(mockApiResponse)
        val repository = CourseRepository(fakeApi)

        val result = repository.getCourses()

        assertNotNull(result)
        assertEquals(2, result.categories.size)
        assertEquals("Android Development", result.categories[0].name)
        assertEquals("Backend & APIs", result.categories[1].name)
    }
}