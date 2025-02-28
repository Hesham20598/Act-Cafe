package com.otherlogic.actcafe.ui.utils

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.otherlogic.actcafe.ui.theme.OrangeColor

@Composable
fun PageIndicator(pagerState: PagerState) {
    val pageCount = pagerState.pageCount
    val dotSize = 10.dp

    Box(
        modifier = Modifier
            .height(30.dp),
        contentAlignment = Alignment.Center
    ) {
        // Dots Row
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(pageCount) { index ->
                CustomSpacer(width = 60)
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(dotSize)
                            .clip(CircleShape)
                            .background(if (pagerState.currentPage == index) Color.Transparent else Color.Gray)
                            .border(
                                width = 2.dp,
                                color = if (pagerState.currentPage == index) OrangeColor else Color.Gray,
                                shape = CircleShape
                            )
                    )
                }
                CustomSpacer(width = 60)

            }
        }

    }
}
