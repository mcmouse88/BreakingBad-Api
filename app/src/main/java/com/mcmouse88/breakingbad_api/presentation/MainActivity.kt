package com.mcmouse88.breakingbad_api.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.mcmouse88.breakingbad_api.data.navigation.SetupNavigation
import com.mcmouse88.breakingbad_api.presentation.ui.theme.BreakingBadApiTheme
import com.mcmouse88.breakingbad_api.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BreakingBadApiTheme {
                val navController = rememberNavController()
                val viewModel = hiltViewModel<MainViewModel>()
                SetupNavigation(navController = navController, viewModel = viewModel)
            }
        }
    }
}