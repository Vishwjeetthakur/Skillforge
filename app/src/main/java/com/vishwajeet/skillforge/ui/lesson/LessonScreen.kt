package com.vishwajeet.skillforge.ui.lesson


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vishwajeet.skillforge.data.model.Course
import com.vishwajeet.skillforge.data.model.Lesson

@Composable
fun LessonScreen(
    course: Course,
    currentLesson: Lesson,
    onLessonClick: (Lesson) -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(
        containerColor = Color(0xFFF9F9F8)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // 1. Top Video Player UI Canvas
            VideoPlayerSection(
                courseTitle = course.title,
                onBackClick = onBackClick
            )

            // 2. Main Scrollable Metadata & Lesson List
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 24.dp)
            ) {
                item {
                    LessonHeaderSection(
                        courseTitle = course.title,
                        lesson = currentLesson
                    )
                }

                item {
                    LessonTabsSection()
                }

                // 3. Bottom Playlist Mapping Loop
                itemsIndexed(course.lessons) { index, lesson ->
                    val isCurrent = lesson.title == currentLesson.title
                    LessonPlaylistItem(
                        index = index + 1,
                        lesson = lesson,
                        isPlaying = isCurrent,
                        onClick = { onLessonClick(lesson) }
                    )
                }
            }
        }
    }
}