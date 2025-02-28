package com.otherlogic.actcafe.ui.screens.SplashActivity

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.otherlogic.actcafe.Screens
import com.otherlogic.actcafe.ui.screens.DashboardScreen.DashboardScreen
import com.otherlogic.actcafe.ui.screens.DashboardScreen.DashboardViewModel
import com.otherlogic.actcafe.ui.screens.LanguageScreen.LanguageScreen
import com.otherlogic.actcafe.ui.screens.LanguageScreen.LanguageScreenViewModel
import com.otherlogic.actcafe.ui.theme.ACTCAFETheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val splashViewModel: SplashScreenViewModel = hiltViewModel()
            val navController = rememberNavController()
            ACTCAFETheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SplashScreenContent(
                        navController = navController,
                        paddingValues = innerPadding,
                        splashScreenViewModel = splashViewModel
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun SplashScreenContent(
    navController: NavHostController,
    paddingValues: PaddingValues,
    splashScreenViewModel: SplashScreenViewModel
) {
    val dashboardViewModel: DashboardViewModel = hiltViewModel()
    val languageViewModel: LanguageScreenViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = Screens.SPLASH_SCREEN.name
    ) {
        composable(Screens.SPLASH_SCREEN.name) {
            SplashScreen(
                paddingValues,
                navController = navController,
                vm = splashScreenViewModel
            )
        }

        composable(Screens.LanguageScreen.name) {
            LanguageScreen(paddingValues, navController, vm = languageViewModel)
        }
        composable(Screens.DashboardScreen.name) {
            DashboardScreen(paddingValues, vm = dashboardViewModel)
        }

    }
}

