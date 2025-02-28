package com.otherlogic.actcafe.ui.screens.MainActivity

import ScanQRScreen
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.otherlogic.actcafe.HelperClass.getCurrentLocale
import com.otherlogic.actcafe.HelperClass.getSavedLocale
import com.otherlogic.actcafe.HelperClass.setLocale
import com.otherlogic.actcafe.R
import com.otherlogic.actcafe.Screens
import com.otherlogic.actcafe.ui.screens.DashboardScreen.DashboardViewModel
import com.otherlogic.actcafe.ui.screens.MainScreen.MainScreen
import com.otherlogic.actcafe.ui.screens.MainScreen.MainViewModel
import com.otherlogic.actcafe.ui.screens.MenuScreen.MenuScreen
import com.otherlogic.actcafe.ui.screens.SplashActivity.SplashScreenViewModel
import com.otherlogic.actcafe.ui.theme.ACTCAFETheme
import com.otherlogic.actcafe.ui.theme.OrangeColor
import com.otherlogic.actcafe.ui.utils.CustomSpacer
import com.otherlogic.actcafe.ui.utils.MainAppBar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(OrangeColor.toArgb(), OrangeColor.toArgb()),
            navigationBarStyle = SystemBarStyle.light(
                OrangeColor.toArgb(),
                OrangeColor.toArgb()
            )
        )
        setContent {
            ACTCAFETheme {
                MainActivityContent()
            }
        }
        setLocale(getSavedLocale(this))
    }
}

@Composable
fun MainActivityContent(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val isArabic by rememberSaveable {
        mutableStateOf(context.getCurrentLocale().language == "ar")
    }
    val navController = rememberNavController()
    var paddingValues by rememberSaveable {
        mutableStateOf<PaddingValues?>(null)
    }
    val vm: MainViewModel = hiltViewModel()
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = navController.currentBackStackEntryAsState().value?.destination?.route == Screens.MENU_SCREEN.name,
        drawerContent = {
            val drawerScreens = listOf(
                stringResource(R.string.profile),
                stringResource(R.string.orders),
                stringResource(R.string.about),
                stringResource(R.string.share)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(.7f)
                    .background(Color.White)
                    .fillMaxHeight()
            ) {
                Column(

                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                ) {
                    Spacer(modifier = Modifier.height(paddingValues?.calculateTopPadding() ?: 0.dp))
                    Image(
                        painter = painterResource(R.drawable.act_logo_image),
                        contentDescription = "act logo image",
                    )
                    CustomSpacer(30)

                    Column(
                        modifier = Modifier
                            .padding(horizontal = 30.dp)
                    ) {

                        drawerScreens.forEachIndexed { index, drawerScreen ->
                            Text(
                                text = drawerScreens[index],
                                style = TextStyle(
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier.clickable(
                                    interactionSource = null,
                                    indication = null
                                ) {
                                    when (drawerScreen) {
                                        context.getString(R.string.profile) -> {

                                        }

                                        context.getString(R.string.orders) -> {

                                        }

                                        context.getString(R.string.about) -> {

                                        }

                                        context.getString(R.string.share) -> {

                                        }
                                    }
                                }

                            )
                            CustomSpacer(20)
                        }
                    }

                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(bottom = paddingValues?.calculateBottomPadding() ?: 0.dp)
                        .align(
                            Alignment.BottomCenter
                        )
                        .fillMaxHeight(.3f)
                        .fillMaxWidth()
                ) {
                    Card(
                        shape = CircleShape,
                        modifier = Modifier.fillMaxWidth(.7f),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        elevation = CardDefaults.cardElevation(4.dp)
                    )
                    {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {

                            Button(
                                onClick = {
                                    context.setLocale("ar")
                                    vm.saveCurrentLanguage("ar")
                                    val intent = (context as Activity).intent
                                    context.finish()
                                    context.startActivity(intent)

                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (isArabic) {
                                        OrangeColor
                                    } else {
                                        Color.Transparent
                                    }
                                )
                            ) {
                                Text(
                                    text = "عربي",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = if (isArabic) {
                                            FontWeight.Normal
                                        } else {
                                            FontWeight.Bold
                                        },
                                        color = if (isArabic) {
                                            Color.White
                                        } else {
                                            Color.Black
                                        }
                                    ),
                                )
                            }


                            Button(
                                onClick = {
                                    context.setLocale("en")
                                    vm.saveCurrentLanguage("en")
                                    val intent = (context as MainActivity).intent
                                    context.finish()
                                    context.startActivity(intent)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (!isArabic) {
                                        OrangeColor
                                    } else {
                                        Color.Transparent
                                    }
                                )
                            ) {
                                Text(
                                    text = "ENG",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = if (!isArabic) {
                                            FontWeight.Normal
                                        } else {
                                            FontWeight.Bold
                                        },
                                        color = if (!isArabic) {
                                            Color.White
                                        } else {
                                            Color.Black
                                        }
                                    ),
                                )
                            }

                        }
                    }
                    CustomSpacer(20)
                    Image(
                        painter = painterResource(R.drawable.checked_icon),
                        contentDescription = "other logic logo image",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
            when (vm.appBarState) {
                Screens.MENU_SCREEN.name -> MainAppBar {
                    scope.launch {
                        drawerState.open()
                    }
                }
            }
        }) { innerPadding ->
            paddingValues = innerPadding
            MainNavGraph(
                navController = navController,
                paddingValues = innerPadding,
                mainViewModel = vm
            )
        }
    }
}

@Composable
fun MainNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues,
    mainViewModel: MainViewModel
) {
    val dashboardViewModel: DashboardViewModel = hiltViewModel()
    val splashScreenViewModel: SplashScreenViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = Screens.MAIN_SCREEN.name
    ) {
//        composable(Screens.SPLASH_SCREEN.name) {
//            SplashScreen(
//                paddingValues,
//                navController = navController,
//                vm = splashScreenViewModel
//            )
//        }
        composable(Screens.MAIN_SCREEN.name) {
            MainScreen(paddingValues, navController)
        }
        composable(Screens.QRCODE_SCREEN.name) {
            ScanQRScreen(navController, paddingValues)
        }
//        composable(Screens.LanguageScreen.name) {
//            LanguageScreen(paddingValues, navController)
//        }
//        composable(Screens.DashboardScreen.name) {
//            DashboardScreen(paddingValues, navController, vm = dashboardViewModel)
//        }

        composable(Screens.MENU_SCREEN.name) {
            mainViewModel.appBarState = Screens.MENU_SCREEN.name
            MenuScreen(paddingValues, navController)
        }
    }
}





