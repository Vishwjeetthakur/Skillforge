package com.vishwajeet.skillforge.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import com.vishwajeet.skillforge.data.model.Category
import com.vishwajeet.skillforge.ui.theme.DarkText
import com.vishwajeet.skillforge.ui.theme.MutedText
import com.vishwajeet.skillforge.ui.theme.TealAccent

@Composable
fun CategoriesSection(categories: List<Category>) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Categories", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = DarkText)
            Text(
                "See all",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = TealAccent,
                modifier = Modifier.clickable { }
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(categories) { category ->
                Card(
                    modifier = Modifier
                        .width(160.dp)
                        .height(150.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(TealAccent.copy(alpha = 0.15f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(16.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(TealAccent)
                            )
                        }

                        Column {
                            Text(
                                text = category.name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                lineHeight = 18.sp,
                                color = DarkText
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "${category.courses.size} courses",
                                fontSize = 12.sp,
                                color = MutedText
                            )
                        }
                    }
                }
            }
        }
    }
}