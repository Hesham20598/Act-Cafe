package com.otherlogic.actcafe.ui.screens.MainScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.otherlogic.actcafe.Screens
import com.otherlogic.actcafe.R
import com.otherlogic.actcafe.ui.theme.OrangeColor

@Composable
fun MainScreen(paddingValues: PaddingValues, navController: NavHostController) {
    val context = LocalContext.current
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = OrangeColor,
            darkIcons = false
        )
        systemUiController.setNavigationBarColor(
            color = OrangeColor,
            darkIcons = false
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = paddingValues.calculateTopPadding(),
                bottom = paddingValues.calculateBottomPadding()
            )
            .paint(
                painter = painterResource(id = R.drawable.coffe_image),
                contentScale = ContentScale.FillBounds
            ),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(.6f),
            onClick = {
                navController.navigate(Screens.QRCODE_SCREEN.name)
            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.textButtonColors(
                containerColor = OrangeColor
            )
        ) {
            Text(
                text = stringResource(R.string.scan_qr),
                style = TextStyle(
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    color = Color.White
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            modifier = Modifier.fillMaxWidth(.6f),
            onClick = {
                navController.navigate(Screens.MENU_SCREEN.name)
            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.textButtonColors(
                containerColor = OrangeColor
            )
        ) {
            Text(
                text = stringResource(R.string.skip),
                style = TextStyle(
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    color = Color.White
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}