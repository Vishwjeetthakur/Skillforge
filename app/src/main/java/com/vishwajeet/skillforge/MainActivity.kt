package com.vishwajeet.skillforge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vishwajeet.skillforge.navigation.NavGraph
import com.vishwajeet.skillforge.ui.home.HomeScreen
import com.vishwajeet.skillforge.ui.home.HomeViewModel
import com.vishwajeet.skillforge.ui.theme.SkillforgeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            SkillforgeTheme {
               NavGraph()
            }
        }
    }
}
