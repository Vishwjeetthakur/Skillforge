package com.vishwajeet.skillforge.ui.lesson

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LessonTabsSection() {
    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Lessons", color = Color(0xFF1A1A1A), fontWeight = FontWeight.Bold, fontSize = 15.sp)
                Spacer(modifier = Modifier.height(6.dp))
                Box(modifier = Modifier.width(40.dp).height(3.dp).background(Color(0xFF009688)))
            }
            Text("Notes", color = Color(0xFF969696), fontSize = 15.sp, modifier = Modifier.padding(top = 0.dp))
            Text("Resources", color = Color(0xFF969696), fontSize = 15.sp)
        }
        HorizontalDivider(color = Color(0xFFEFEFEF), thickness = 1.dp)
        Spacer(modifier = Modifier.height(16.dp))
    }
}