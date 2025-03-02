package com.otherlogic.actcafe.ui.utils

import ScanQRScreen
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.otherlogic.actcafe.Screens
import com.otherlogic.actcafe.ui.screens.CartScreen.CartViewModel
import com.otherlogic.actcafe.ui.screens.ItemDetailsScreen.ItemDetailsScreen
import com.otherlogic.actcafe.ui.screens.ItemDetailsScreen.ItemDetailsViewModel
import com.otherlogic.actcafe.ui.screens.MainScreen.MainScreen
import com.otherlogic.actcafe.ui.screens.MainScreen.MainViewModel
import com.otherlogic.actcafe.ui.screens.MenuScreen.MenuScreen

@Composable
fun MainNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues,
    mainViewModel: MainViewModel,
    cartViewModel: CartViewModel,
    itemDetailsViewModel: ItemDetailsViewModel
) {

    NavHost(
        navController = navController,
        startDestination = Screens.MAIN_SCREEN.name
    ) {

        composable(Screens.MAIN_SCREEN.name) {
            MainScreen(paddingValues, navController)
        }
        composable(Screens.QRCODE_SCREEN.name) {
            ScanQRScreen(navController, paddingValues)
        }


        composable(Screens.MENU_SCREEN.name) {
            mainViewModel.appBarState = Screens.MENU_SCREEN.name
            MenuScreen(
                cartViewModel = cartViewModel,
                paddingValues = paddingValues,
                navController = navController
            )
        }

        composable("${Screens.ITEM_DETAILS_SCREEN.name}/{item_id}",
            arguments = listOf(
                navArgument("item_id") {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("item_id") ?: -1
            mainViewModel.appBarState = Screens.ITEM_DETAILS_SCREEN.name
            ItemDetailsScreen(
                vm = itemDetailsViewModel,
                navHostController = navController,
                id = id
            )
        }
    }
}