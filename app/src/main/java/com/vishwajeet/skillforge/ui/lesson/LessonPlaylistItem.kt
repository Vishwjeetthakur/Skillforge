package com.vishwajeet.skillforge.ui.lesson

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Pause
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vishwajeet.skillforge.data.model.Lesson

@Composable
fun LessonPlaylistItem(
    index: Int,
    lesson: Lesson,
    isPlaying: Boolean,
    onClick: () -> Unit
) {
    val cardBackground = if (isPlaying) Color(0xFFEAF6F4) else Color.White
    val cardBorderColor = if (isPlaying) Color(0xFFBCE2DC) else Color(0xFFEAEAEA)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 6.dp)
            .clickable { if (lesson.isFree || isPlaying) onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = cardBackground),
        border = androidx.compose.foundation.BorderStroke(1.dp, cardBorderColor)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(
                        when {
                            isPlaying -> Color(0xFF009688)
                            lesson.isFree -> Color(0xFF009688).copy(alpha = 0.1f)
                            else -> Color(0xFFF1F1F1)
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = when {
                        isPlaying -> Icons.Default.Pause
                        lesson.isFree -> Icons.Default.PlayArrow
                        else -> Icons.Default.Lock
                    },
                    contentDescription = null,
                    tint = when {
                        isPlaying -> Color.White
                        lesson.isFree -> Color(0xFF009688)
                        else -> Color(0xFFB5B5B5)
                    },
                    modifier = Modifier.size(18.dp)
                )
            }

            // Description Label Info Block
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = lesson.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = if (isPlaying) Color(0xFF00796B) else Color(0xFF1A1A1A)
                )
                Text(
                    text = if (isPlaying) "Now playing · ${lesson.durationMinutes} min" else "${lesson.durationMinutes} min",
                    color = Color(0xFF969696),
                    fontSize = 13.sp
                )
            }

            // Free Label Tag Overlay
            if (lesson.isFree && !isPlaying) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color(0xFFE0F2F1))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "FREE",
                        color = Color(0xFF009688),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}