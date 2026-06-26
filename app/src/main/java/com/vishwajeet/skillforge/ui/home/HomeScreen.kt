package com.vishwajeet.skillforge.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vishwajeet.skillforge.data.model.Course
import com.vishwajeet.skillforge.ui.theme.CreamBg

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    onCourseClick: (Course) -> Unit
) {

    val state by viewModel.uiState.collectAsState()

    when (state) {

        is UiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is UiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = (state as UiState.Error).message)
            }
        }

        is UiState.Success -> {
            val categories = (state as UiState.Success).categories

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(CreamBg),
                contentPadding = PaddingValues(16.dp)
            ) {

                item {
                    HomeHeader()
                }

                item {
                    Spacer(Modifier.height(20.dp))
                }

                item {
                    SearchBar()
                }

                item {
                    Spacer(Modifier.height(28.dp))
                }

                item {
                    CategoriesSection(categories = categories)
                }

                item {
                    Spacer(Modifier.height(28.dp))
                }

                item {
                    PopularCoursesSection(
                        categories = categories,
                        onCourseClick = onCourseClick
                    )
                }
            }
        }


    }

}