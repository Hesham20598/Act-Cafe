package com.otherlogic.actcafe.ui.screens.DashboardScreen

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.otherlogic.actcafe.R
import com.otherlogic.actcafe.Screens
import com.otherlogic.actcafe.ui.screens.MainActivity.MainActivity
import com.otherlogic.actcafe.ui.screens.SplashActivity.SplashActivity
import com.otherlogic.actcafe.ui.theme.OrangeColor
import com.otherlogic.actcafe.ui.utils.CustomSpacer
import com.otherlogic.actcafe.ui.utils.PageIndicator
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun DashboardScreen(
    paddingValues: PaddingValues,
    vm: DashboardViewModel
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    var globalIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    HideNavigationBarScreen()
    val dashboardScreens = listOf<@Composable () -> Unit>(
        {
            DashboardDesign(
                R.drawable.first_dashboard_image,
                title = context.getString(R.string.easy_ordering),
                description = context.getString(R.string.you_will_save_your_time_by_getting_online_order)
            )
        },
        {
            DashboardDesign(
                R.drawable.second_dashboard_image,
                title = context.getString(R.string.scan_qr_room_code),
                description = context.getString(R.string.scan_qr_room_code_to_get_the_menu)
            )
        }
    )
    val pagerState = rememberPagerState(pageCount = { dashboardScreens.size })
    DisposableEffect(Unit) {

        onDispose {

        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(
                top = paddingValues.calculateTopPadding(),
                bottom = paddingValues.calculateBottomPadding()
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { index ->

            globalIndex = index
            dashboardScreens[index].invoke()

        }
        Column(
            modifier = Modifier.fillMaxHeight(.30f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomSpacer(30)
            PageIndicator(
                pagerState = pagerState
            )
            CustomSpacer(30)

            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = OrangeColor
                ),
                shape = RectangleShape,
                onClick = {
                    if (pagerState.currentPage + 1 == dashboardScreens.size) {
                        vm.saveFirstRun(false)
                        val intent = Intent(context, MainActivity::class.java)
                        context.startActivity(intent)
                        (context as SplashActivity).finish()
                    } else {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(
                                pagerState.currentPage + 1,
                                animationSpec = tween(durationMillis = 800)
                            )
                        }
                    }
                }) {
                Text(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    text =
                    if (globalIndex == 0) {
                        stringResource(R.string.next)
                    } else {
                        stringResource(R.string.start)
                    }
                )
            }
        }
    }


}

@Composable
fun DashboardDesign(@DrawableRes imageRes: Int, title: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = title,
            style = TextStyle(
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        )
        CustomSpacer(12)
        Text(
            text = description,
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Black
            )
        )
    }
}

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun HideNavigationBarScreen() {
    val context = LocalContext.current
    val activity = context as Activity
    val window = activity.window
    val controller = window.insetsController

    LaunchedEffect(Unit) {
        controller?.systemBarsBehavior =
            WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        controller?.hide(WindowInsets.Type.navigationBars())
    }
//        DisposableEffect(Unit) {
//            onDispose {
//                controller?.show(WindowInsets.Type.navigationBars())
//            }
//    }
}
