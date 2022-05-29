package com.mcmouse88.breakingbad_api.data.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mcmouse88.breakingbad_api.presentation.screens.DetailScreen
import com.mcmouse88.breakingbad_api.presentation.screens.MainScreen
import com.mcmouse88.breakingbad_api.presentation.screens.SplashScreen
import com.mcmouse88.breakingbad_api.presentation.viewmodel.MainViewModel

@Composable
fun SetupNavigation(navController: NavHostController, viewModel: MainViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController, viewModel = viewModel)
        }

        composable(route = Screens.Main.route) {
            MainScreen(navController = navController, viewModel = viewModel)
        }

        composable(route = Screens.Detail.route + "/{id}") {backStackEntry ->
            DetailScreen(
                viewModel = viewModel,
                itemId = backStackEntry.arguments?.getString("id") ?: "1"
            )
        }
    }
}