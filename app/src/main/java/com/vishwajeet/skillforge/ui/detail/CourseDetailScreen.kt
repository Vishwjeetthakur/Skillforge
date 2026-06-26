package com.vishwajeet.skillforge.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vishwajeet.skillforge.data.model.Course
import com.vishwajeet.skillforge.data.model.Lesson
import com.vishwajeet.skillforge.ui.theme.CreamBg
import com.vishwajeet.skillforge.ui.theme.DarkTeal
import com.vishwajeet.skillforge.ui.theme.DarkText
import com.vishwajeet.skillforge.ui.theme.MutedText
import com.vishwajeet.skillforge.ui.theme.TealAccent


@Composable
fun CourseDetailScreen(
    course: Course,
    onBackClick: () -> Unit,
    onLessonClick: (Lesson) -> Unit
) {
    Scaffold(
        containerColor = CreamBg,
        bottomBar = {
            EnrollmentBottomBar(price = "Free")
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            // 1. Hero Image / Background Banner Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .background(DarkTeal)
            ) {
                // Header Action Buttons Overlay
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .statusBarsPadding()
                        .padding(horizontal = 20.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color.White, CircleShape)
                    ) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = DarkText)
                    }

                    IconButton(
                        onClick = { /* Handle bookmark */ },
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color.White, CircleShape)
                    ) {
                        // Custom bookmark representation
                        Text("🔖", fontSize = 16.sp)
                    }
                }

                // Header Metadata Overlay Layout
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.White.copy(alpha = 0.2f), RoundedCornerShape(8.dp))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text("// ${course.level.lowercase()}", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }

                    Text(
                        text = course.title,
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 34.sp
                    )

                    // Small inline tags (mocking details from UI image)
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        listOf("Kotlin", "Basics", "JVM").forEach { tag ->
                            Box(
                                modifier = Modifier
                                    .background(Color.White.copy(alpha = 0.15f), RoundedCornerShape(6.dp))
                                    .padding(horizontal = 10.dp, vertical = 4.dp)
                            ) {
                                Text(tag, color = Color.White, fontSize = 11.sp)
                            }
                        }
                    }
                }
            }

            // 2. Info Body Content Section
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                // Course Text Data descriptions
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(text = course.title, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = DarkText)
                    Text(text = "Everything you need to start writing Kotlin", fontSize = 15.sp, color = MutedText)
                }

                // Specs Metadata Row
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("⭐")
                        Text(course.rating.toString(), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Text("18,420", color = MutedText, fontSize = 14.sp) // Mock total enrollment
                    }
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("🕒")
                        Text("${course.durationHours}h", color = DarkText, fontSize = 14.sp, fontWeight = FontWeight.Medium)
                    }
                    Text(course.level, color = Color(0xFF009688), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }

                // 3. Instructor Profiler Card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                            // Avatar Fallback placeholder circle
                            Box(
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF009688)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("AS", color = Color.White, fontWeight = FontWeight.Bold)
                            }
                            Column {
                                Text(course.instructor.name, fontWeight = FontWeight.Bold, color = DarkText, fontSize = 16.sp)
                                Text(course.instructor.title, color = MutedText, fontSize = 13.sp)
                            }
                        }
                        Text(
                            text = "Follow",
                            color = Color(0xFF009688),
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            modifier = Modifier.clickable { /* Toggle follow */ }
                        )
                    }
                }

                // Detailed Descriptive Bio Text block
                Text(
                    text = "Start from zero and learn Kotlin's syntax, null safety, collections, and functions. By the end you'll be comfortable reading and writing idiomatic Kotlin.",
                    color = Color(0xFF4A4A4A),
                    fontSize = 14.sp,
                    lineHeight = 22.sp
                )

                // 4. Course Syllabus Structure Content
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Course content", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = DarkText)
                        val totalMinutes = course.lessons.sumOf { it.durationMinutes }
                        Text(
                            text = "${course.lessons.size} lessons · ${totalMinutes} min",
                            fontSize = 13.sp,
                            color = MutedText
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Map through specific nested lessons lists
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        course.lessons.forEach { lesson ->
                            LessonItemRow(lesson = lesson, onLessonClick = onLessonClick)
                        }
                    }
                }
            }
        }
    }
}

