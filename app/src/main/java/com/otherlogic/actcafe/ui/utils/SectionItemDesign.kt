@file:OptIn(ExperimentalGlideComposeApi::class)

package com.otherlogic.actcafe.ui.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.otherlogic.actcafe.HelperClass.IMAGE_URL
import com.otherlogic.actcafe.HelperClass.getCurrentLocale
import com.otherlogic.actcafe.R
import com.otherlogic.actcafe.ui.theme.OrangeColor
import com.otherlogic.domain.entity.menu.MenuItemDto

@Composable
fun SectionItemDesign(
    modifier: Modifier = Modifier,
    item: MenuItemDto,
    onItemClicked: () -> Unit,
    onAddToCartClicked: () -> Unit
) {
    val context = LocalContext.current
    val isArabic by rememberSaveable {
        mutableStateOf(context.getCurrentLocale().language == "ar")
    }
    Card(
        modifier = modifier
            .clickable(interactionSource = null, indication = null) {
                onItemClicked()
            }
            .fillMaxWidth()
            .height(100.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val (itemName, itemDescription, itemImage, itemPrice, addToCart) = createRefs()
            GlideImage(
                contentScale = ContentScale.FillBounds,
                model = IMAGE_URL + item.image,
                contentDescription = "item image",
                loading = placeholder(R.drawable.first_dashboard_image),
                failure = placeholder(R.drawable.first_dashboard_image),
                modifier = Modifier
                    .size(100.dp)
                    .constrainAs(itemImage) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        height = Dimension.fillToConstraints
                    })
            Text(
                text = if (isArabic) item.name_ar ?: "" else item.name_en ?: "",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.constrainAs(itemName) {
                    top.linkTo(parent.top, margin = 8.dp)
                    start.linkTo(itemImage.end, margin = 8.dp)
                }
            )
            Text(
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                text = if (isArabic) item.description_ar ?: "" else item.description_en ?: "",
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(itemDescription) {
                        top.linkTo(itemName.bottom, margin = 8.dp)
                        start.linkTo(itemName.start, margin = 2.dp)
                        end.linkTo(parent.end, margin = 8.dp)
                        width = Dimension.fillToConstraints
                    }
            )
            Text(
                maxLines = 1,
                text = "${item.info?.get(0)?.price?.price} ${stringResource(R.string.egp)}",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(itemPrice) {
                        bottom.linkTo(parent.bottom, margin = 8.dp)
                        start.linkTo(itemName.start)
                    }
            )

            Button(
                modifier = Modifier.constrainAs(addToCart) {
                    end.linkTo(parent.end, margin = 8.dp)
                    bottom.linkTo(parent.bottom, margin = 4.dp)
                },
                colors = ButtonDefaults.buttonColors(containerColor = OrangeColor),
                onClick = {
                    onAddToCartClicked()
                }
            ) {
                Text(stringResource(R.string.add_to_cart))
            }


        }
    }
}