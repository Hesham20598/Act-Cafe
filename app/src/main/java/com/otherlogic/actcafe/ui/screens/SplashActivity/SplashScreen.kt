package com.otherlogic.actcafe.ui.screens.SplashActivity

import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import com.otherlogic.actcafe.Screens
import com.otherlogic.actcafe.R
import com.otherlogic.actcafe.ui.screens.DashboardScreen.HideNavigationBarScreen
import com.otherlogic.actcafe.ui.screens.MainActivity.MainActivity
import kotlinx.coroutines.delay

@RequiresApi(Build.VERSION_CODES.R)
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SplashScreen(
    paddingValues: PaddingValues,
    navController: NavHostController,
    vm: SplashScreenViewModel
) {
    val context = LocalContext.current
    HideNavigationBarScreen()
    LaunchedEffect(Unit) {
        delay(2000)
        if (vm.getFirstRun()) {
            navController.navigate(Screens.LanguageScreen.name) {
                popUpTo(0)
            }
        } else {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
            (context as? SplashActivity)?.finish()
        }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(Color.White)
            .padding(top = paddingValues.calculateTopPadding())
            .fillMaxSize()
    ) {
        Image(
            painter = rememberDrawablePainter(
                drawable = context.getDrawable(
                    R.drawable.splash_screen
                )
            ),
            contentDescription = "splash screen",
        )
    }
}

