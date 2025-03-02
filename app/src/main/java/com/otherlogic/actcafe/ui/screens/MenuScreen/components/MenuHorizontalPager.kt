package com.otherlogic.actcafe.ui.screens.MenuScreen.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.otherlogic.actcafe.ui.screens.MenuScreen.MenuViewModel
import com.otherlogic.actcafe.ui.theme.OrangeColor
import com.otherlogic.actcafe.ui.utils.CustomSpacer
import kotlinx.coroutines.delay

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuHorizontalPager(vm: MenuViewModel = hiltViewModel()) {

    val pagerState = rememberPagerState { vm.offers.size }
    LaunchedEffect(Unit) {
        while (true) {
            if (pagerState.currentPage < pagerState.pageCount - 1) {
                delay(5000)
                pagerState.animateScrollToPage(
                    pagerState.currentPage + 1,
                    animationSpec = tween(durationMillis = 4000)
                )
            } else {
                delay(5000)
                if (!pagerState.isScrollInProgress) {
                    pagerState.canScrollForward
                    pagerState.animateScrollToPage(
                        0,
                        animationSpec = tween(durationMillis = 4000)
                    )
                }
            }
        }
    }
    if (vm.images.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.25f),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = OrangeColor
            )
        }
    } else {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.25f)
                .background(Color.Black)
        ) {
            val (horizontalPager, indicator) = createRefs()

            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxSize()
                    .constrainAs(horizontalPager) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            ) { page ->
                GlideImage(
//                    loading = placeholder(R.drawable.first_dashboard_image),
                    model = vm.images[page],
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            }

            Row(modifier = Modifier
                .constrainAs(indicator) {
                    bottom.linkTo(horizontalPager.bottom, margin = 20.dp)
                }
                .fillMaxWidth(), horizontalArrangement = Arrangement.Center) {

                repeat(vm.offers.size) { index ->
                    CustomSpacer(width = 2)
                    Spacer(
                        modifier = Modifier
                            .size(8.dp)
                            .background(
                                if (pagerState.currentPage == index) OrangeColor else Color.White,
                                shape = CircleShape
                            )
                    )
                    CustomSpacer(width = 2)
                }

            }
        }
    }
}