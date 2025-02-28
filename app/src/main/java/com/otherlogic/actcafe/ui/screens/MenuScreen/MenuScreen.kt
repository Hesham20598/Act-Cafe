package com.otherlogic.actcafe.ui.screens.MenuScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.otherlogic.actcafe.ui.utils.MenuHorizontalPager

@Composable
fun MenuScreen(paddingValues: PaddingValues, navController: NavHostController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = paddingValues.calculateTopPadding())
    ) {

        MenuHorizontalPager()


    }
}