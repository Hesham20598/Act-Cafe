package com.otherlogic.actcafe.ui.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomSpacer(
    height: Int = 0,
    modifier: Modifier = Modifier,
    width: Int = 0,
    widthRatio: Float = 0f,
    backGroundColor: Color = Color.Transparent
) {
    Spacer(
        modifier =
        modifier
            .height(height.dp)
            .width(width.dp)
            .fillMaxWidth(widthRatio)
            .background(backGroundColor)
    )
}