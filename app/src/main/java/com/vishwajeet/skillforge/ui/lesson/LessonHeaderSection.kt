package com.vishwajeet.skillforge.ui.lesson

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vishwajeet.skillforge.data.model.Lesson

@Composable
fun LessonHeaderSection(courseTitle: String, lesson: Lesson) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Text(
            text = "LESSON 1 · ${courseTitle.uppercase()}",
            color = Color(0xFF009688),
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.5.sp
        )
        Text(
            text = lesson.title,
            color = Color(0xFF1A1A1A),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = lesson.content,
            color = Color(0xFF707070),
            fontSize = 14.sp,
            lineHeight = 20.sp
        )
    }
}