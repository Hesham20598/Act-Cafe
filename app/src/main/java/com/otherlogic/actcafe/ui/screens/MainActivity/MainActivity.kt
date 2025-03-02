package com.otherlogic.actcafe.ui.screens.MainActivity

import ScanQRScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.otherlogic.actcafe.HelperClass.getCurrentLocale
import com.otherlogic.actcafe.HelperClass.getSavedLocale
import com.otherlogic.actcafe.HelperClass.setLocale
import com.otherlogic.actcafe.Screens
import com.otherlogic.actcafe.ui.screens.CartScreen.CartViewModel
import com.otherlogic.actcafe.ui.screens.ItemDetailsScreen.ItemDetailsScreen
import com.otherlogic.actcafe.ui.screens.ItemDetailsScreen.ItemDetailsViewModel
import com.otherlogic.actcafe.ui.screens.MainScreen.MainScreen
import com.otherlogic.actcafe.ui.screens.MainScreen.MainViewModel
import com.otherlogic.actcafe.ui.screens.MenuScreen.MenuScreen
import com.otherlogic.actcafe.ui.theme.ACTCAFETheme
import com.otherlogic.actcafe.ui.theme.OrangeColor
import com.otherlogic.actcafe.ui.utils.MainAppBar
import com.otherlogic.actcafe.ui.utils.MainNavGraph
import com.otherlogic.actcafe.ui.utils.SideMenuContent
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
//        setLocale(getSavedLocale(this))

        setContent {
            ACTCAFETheme {
                MainActivityContent()
            }
        }

    }
}

@Composable
fun MainActivityContent() {
    val context = LocalContext.current
    val isArabic by rememberSaveable {
        mutableStateOf(context.getCurrentLocale().language == "ar")
    }
    val navController = rememberNavController()
    var paddingValues by rememberSaveable {
        mutableStateOf<PaddingValues?>(null)
    }
    val vm: MainViewModel = hiltViewModel()
    val cartViewModel: CartViewModel = hiltViewModel()
    val itemDetailsViewModel: ItemDetailsViewModel = hiltViewModel()
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = navController.currentBackStackEntryAsState().value?.destination?.route == Screens.MENU_SCREEN.name,
        drawerContent = {
            SideMenuContent(paddingValues, vm, isArabic)
        }
    ) {

        Scaffold(modifier = Modifier.fillMaxSize(), topBar = {

            when (vm.appBarState) {
                Screens.MENU_SCREEN.name -> MainAppBar(cartViewModel = cartViewModel) {
                    scope.launch {
                        drawerState.open()
                    }
                }

                else -> {

                }
            }
        }) { innerPadding ->
            paddingValues = innerPadding
            MainNavGraph(
                navController = navController,
                paddingValues = innerPadding,
                mainViewModel = vm,
                cartViewModel = cartViewModel,
                itemDetailsViewModel = itemDetailsViewModel
            )
        }
    }
}








