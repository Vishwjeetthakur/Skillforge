package com.vishwajeet.skillforge.ui.home

import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vishwajeet.skillforge.data.model.Category // Check package match
import com.vishwajeet.skillforge.data.model.Course
import com.vishwajeet.skillforge.ui.theme.DarkTeal
import com.vishwajeet.skillforge.ui.theme.DarkText
import com.vishwajeet.skillforge.ui.theme.TealAccent


@Composable
fun PopularCoursesSection(
    categories: List<Category>,
    onCourseClick: (Course) -> Unit
) {
    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Popular courses", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = DarkText)
            Text(
                "See all",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = TealAccent,
                modifier = Modifier.clickable { }
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        val allCourses = categories.flatMap { it.courses }

        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            allCourses.forEach { course ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onCourseClick(course) },
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AsyncImage(
                            model = course.thumbnailUrl,
                            contentDescription = null,
                            modifier = Modifier
                                .size(84.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .background(DarkTeal),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.spacedBy(2.dp)
                        ) {
                            val isIntermediate = course.level.equals("Intermediate", ignoreCase = true)
                            Text(
                                text = course.level.uppercase(),
                                color = if (isIntermediate) Color(0xFFE69A24) else Color(0xFF009688),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 0.5.sp
                            )
                            Text(text = course.title, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color(0xFF1A1A1A))
                            Text(text = course.instructor.name, color = Color(0xFF969696), fontSize = 13.sp)

                            Spacer(modifier = Modifier.height(4.dp))

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text("⭐", fontSize = 12.sp)
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(text = course.rating.toString(), fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1A1A1A))
                                }
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text("🕒", fontSize = 12.sp)
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(text = "${course.durationHours}h", fontSize = 13.sp, color = Color(0xFF969696))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}