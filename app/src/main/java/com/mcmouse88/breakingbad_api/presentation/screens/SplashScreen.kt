package com.mcmouse88.breakingbad_api.presentation.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mcmouse88.breakingbad_api.R
import com.mcmouse88.breakingbad_api.data.navigation.Screens
import com.mcmouse88.breakingbad_api.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController, viewModel: MainViewModel) {
    var startAnimation by remember {
        mutableStateOf(false)
    }

    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 3000)
    )
    LaunchedEffect(key1 = true) {
        startAnimation = true
        viewModel.getAllCharacter()
        delay(4000)
        navController.navigate(Screens.Main.route)
    }
    SplashLayout(alpha = alphaAnimation.value)
}

@Composable
fun SplashLayout(alpha: Float) {
    Image(
        painter = painterResource(id = R.drawable.splash),
        modifier = Modifier
            .fillMaxSize()
            .alpha(alpha = alpha),
        contentDescription = null,
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 20.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .height(10.dp),
            backgroundColor = Color.LightGray,
            color = Color.Blue
        )
    }
}