package com.vishwajeet.skillforge.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vishwajeet.skillforge.data.model.Lesson
import com.vishwajeet.skillforge.ui.theme.DarkText
import com.vishwajeet.skillforge.ui.theme.MutedText

@Composable
fun LessonItemRow(
    lesson: Lesson,
    onLessonClick: (Lesson) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { if (lesson.isFree) onLessonClick(lesson) },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (lesson.isFree) Color.White else Color.White.copy(alpha = 0.6f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.5.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier.weight(1f)
            ) {
                // Circle Status Icon Action Button Indicator
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(if (lesson.isFree) Color(0xFFE6F2F2) else Color(0xFFF2F2F2)),
                    contentAlignment = Alignment.Center
                ) {
                    if (lesson.isFree) {
                        Icon(Icons.Default.PlayArrow, contentDescription = "Play", tint = Color(0xFF009688))
                    } else {
                        Icon(Icons.Default.Lock, contentDescription = "Locked", tint = MutedText, modifier = Modifier.size(16.dp))
                    }
                }

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = lesson.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = if (lesson.isFree) DarkText else MutedText,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "${lesson.durationMinutes} min",
                        color = MutedText,
                        fontSize = 13.sp
                    )
                }
            }

            if (lesson.isFree) {
                Box(
                    modifier = Modifier
                        .background(Color(0xFFE6F2F2), RoundedCornerShape(6.dp))
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text("FREE", color = Color(0xFF009688), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

