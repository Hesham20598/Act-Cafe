package com.otherlogic.actcafe.ui.utils

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.otherlogic.actcafe.R
import com.otherlogic.actcafe.ui.screens.CartScreen.CartViewModel
import com.otherlogic.actcafe.ui.theme.OrangeColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CartIconWithBadge(
    modifier: Modifier = Modifier,
    vm: CartViewModel,
    onLongClick:()->Unit,
    onClick: () -> Unit = {}

) {
    ConstraintLayout(
        modifier = modifier
            .combinedClickable(interactionSource = null, indication = null, onClick = {
                onClick()
            }, onLongClick = {
                onLongClick()
            })
            .wrapContentWidth()
            .background(OrangeColor)
    ) {
        val (cartIcon, textBox) = createRefs()

        Icon(
            painter = painterResource(R.drawable.cart_icon),
            contentDescription = "cart icon",
            modifier = Modifier
                .size(28.dp)
                .constrainAs(cartIcon) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            tint = Color.White
        )
        if (vm.cartItemCount != 0) {
            Text(
                text = vm.cartItemCount.toString(),
                modifier = Modifier
                    .background(OrangeColor, shape = CircleShape)
                    .padding(top = 3.dp, bottom = 2.dp, end = 4.dp)
                    .constrainAs(textBox) {
                        end.linkTo(cartIcon.start, margin = (-11).dp)
                        top.linkTo(cartIcon.top, margin = 8.dp)
                        bottom.linkTo(cartIcon.bottom)
                    },
                style = TextStyle(
                    fontSize = 13.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Normal
                )
            )
        }
    }

}

