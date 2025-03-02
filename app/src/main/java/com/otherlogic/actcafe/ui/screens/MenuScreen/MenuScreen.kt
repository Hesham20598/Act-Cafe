package com.otherlogic.actcafe.ui.screens.MenuScreen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.otherlogic.actcafe.HelperClass.getCurrentLocale
import com.otherlogic.actcafe.R
import com.otherlogic.actcafe.ui.screens.CartScreen.CartViewModel
import com.otherlogic.actcafe.ui.screens.MenuScreen.components.MenuHorizontalPager
import com.otherlogic.actcafe.ui.screens.MenuScreen.components.MenuLazyColumn
import com.otherlogic.actcafe.ui.screens.MenuScreen.components.MenuTabRow
import com.otherlogic.actcafe.ui.utils.CustomSpacer
import com.otherlogic.actcafe.ui.utils.LoadingDialog

@Composable
fun MenuScreen(
    paddingValues: PaddingValues,
    navController: NavHostController,
    vm: MenuViewModel = hiltViewModel(),
    cartViewModel: CartViewModel
) {
    val context = LocalContext.current
    var isArabic by rememberSaveable {
        mutableStateOf(context.getCurrentLocale().language == "ar")
    }

    LaunchedEffect(Unit) {
        vm.getOffers()
        vm.getMenu()
    }

    LaunchedEffect(Unit) {
//        cartViewModel.getCartItemCount()
    }

    LaunchedEffect(vm.errorMessage, vm.responseMessage) {
        if (vm.errorMessage.isNotBlank()) {
            when (vm.errorMessage) {
                "No Internet Connection" -> Toast.makeText(
                    context,
                    context.getString(R.string.no_internet_connection),
                    Toast.LENGTH_LONG
                ).show()

                "response is false" -> Toast.makeText(
                    context,
                    context.getString(R.string.response_is_false),
                    Toast.LENGTH_LONG
                ).show()

                else -> Toast.makeText(context, vm.errorMessage, Toast.LENGTH_LONG).show()
            }
            vm.errorMessage = ""
        }
        if (vm.responseMessage.isNotBlank()) {
            Toast.makeText(context, vm.responseMessage, Toast.LENGTH_LONG).show()
            vm.responseMessage = ""
        }
    }

    LoadingDialog(vm.isLoading)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White.copy(.2f))
            .padding(
                top = paddingValues.calculateTopPadding(),
                bottom = paddingValues.calculateBottomPadding() + 4.dp
            )
    ) {

        MenuHorizontalPager()
        CustomSpacer(12)
        MenuTabRow(vm, isArabic)
        CustomSpacer(20)
        MenuLazyColumn(modifier = Modifier.weight(1f), vm, navController, cartViewModel, isArabic)


    }
}



