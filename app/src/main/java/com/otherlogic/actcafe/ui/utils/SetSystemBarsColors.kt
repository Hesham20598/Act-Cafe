package com.otherlogic.actcafe.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SetSystemBarsColor(statusBarColor: Color, navigationBarColor: Color) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = statusBarColor.luminance() > 0.5f // Use dark icons if the background is light
        )
        systemUiController.setNavigationBarColor(
            color = navigationBarColor,
            darkIcons = navigationBarColor.luminance() > 0.5f
        )
    }
}