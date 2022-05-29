package com.mcmouse88.breakingbad_api.data.navigation

import com.mcmouse88.breakingbad_api.domain.utils.Constants.Screens.SPLASH_SCREEN
import com.mcmouse88.breakingbad_api.domain.utils.Constants.Screens.MAIN_SCREEN
import com.mcmouse88.breakingbad_api.domain.utils.Constants.Screens.DETAIL_SCREEN

sealed class Screens(val route: String) {
    object Splash: Screens(route = SPLASH_SCREEN)
    object Main: Screens(route = MAIN_SCREEN)
    object Detail: Screens(route = DETAIL_SCREEN)
}