package com.otherlogic.actcafe.ui.screens.LanguageScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.otherlogic.actcafe.HelperClass.setLocale
import com.otherlogic.actcafe.Screens
import com.otherlogic.actcafe.R
import com.otherlogic.actcafe.ui.utils.CustomSpacer

@Composable
fun LanguageScreen(
    paddingValues: PaddingValues,
    navHostController: NavHostController,
    vm: LanguageScreenViewModel
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = paddingValues.calculateTopPadding()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text =
            stringResource(R.string.please_select_language), style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black.copy(.5f)
            )
        )
        CustomSpacer(30)
        Text(
            text =
            stringResource(R.string.you_can_change_this_later_in_settings), style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black.copy(.5f)
            )
        )
        CustomSpacer(40)
        Card(
            shape = RectangleShape,
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.White)
                .clickable(interactionSource = null, indication = null) {
                    vm.saveCurrentLanguage("ar")
                    context.setLocale("ar")
                    navHostController.navigate(Screens.DashboardScreen.name)
                }, elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    "العربية", style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black.copy(.6f)
                    )
                )
            }
        }

        CustomSpacer(30)
        Card(
            shape = RectangleShape,
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clickable(interactionSource = null, indication = null) {
                    vm.saveCurrentLanguage("en")
                    navHostController.navigate(Screens.DashboardScreen.name)
                    context.setLocale("en")
                }, elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    "English", style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black.copy(.6f)
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}