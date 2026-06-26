package com.vishwajeet.skillforge.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vishwajeet.skillforge.ui.detail.CourseDetailScreen
import com.vishwajeet.skillforge.ui.home.HomeScreen
import com.vishwajeet.skillforge.ui.home.HomeViewModel
import com.vishwajeet.skillforge.ui.lesson.LessonScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    homeViewModel: HomeViewModel = viewModel(),
    sharedNavViewModel: SharedNavigationViewModel = viewModel()
){

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                viewModel = homeViewModel,
                onCourseClick = { course ->
                    sharedNavViewModel.selectCourse(course)
                    navController.navigate(Screen.CourseDetail.route)
                }
            )
        }

        composable(route = Screen.CourseDetail.route) {
            val course by sharedNavViewModel.selectedCourse.collectAsState()

            course?.let { validCourse ->
                CourseDetailScreen(
                    course = validCourse,
                    onLessonClick = { lesson ->
                        sharedNavViewModel.selectLesson(lesson)
                        navController.navigate(Screen.Lesson.route)
                    },
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }

        composable(route = Screen.Lesson.route) {
            val course by sharedNavViewModel.selectedCourse.collectAsState()
            val lesson by sharedNavViewModel.selectedLesson.collectAsState()

            if (course != null && lesson != null) {
                LessonScreen(
                    course = course!!,
                    currentLesson = lesson!!,
                    onLessonClick = { nextLesson ->
                        sharedNavViewModel.selectLesson(nextLesson)
                    },
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }

}