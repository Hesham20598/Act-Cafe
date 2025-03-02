package com.otherlogic.actcafe.ui.utils

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.otherlogic.actcafe.R
import com.otherlogic.actcafe.ui.screens.CartScreen.CartViewModel
import com.otherlogic.actcafe.ui.screens.MainScreen.MainViewModel
import com.otherlogic.actcafe.ui.theme.OrangeColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBar(
    cartViewModel: CartViewModel,
    onMenuClicked: () -> Unit
) {
    val context = LocalContext.current
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = OrangeColor
        ),
        title = {
            Text(
                text = stringResource(R.string.menu),
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "menu icon",
                tint = Color.White,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .size(24.dp)
                    .clickable(interactionSource = null, indication = null) {
                        onMenuClicked()
                    }
            )
        },
        actions = {
            CartIconWithBadge(
                modifier = Modifier.padding(end = 12.dp),
                vm = cartViewModel,
                onLongClick = {
                    cartViewModel.clearCartItems()
                }
            ) {
                Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
            }
        }
    )

}
//
//@Preview
//@Composable
//private fun TopAppBarPreview() {
//    MainAppBar { }
//}