package com.otherlogic.actcafe.ui.screens.ItemDetailsScreen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.otherlogic.actcafe.HelperClass.IMAGE_URL
import com.otherlogic.actcafe.R
import com.otherlogic.actcafe.ui.utils.CustomSpacer
import com.otherlogic.actcafe.ui.utils.LoadingDialog
import com.otherlogic.domain.entity.itemDetails.ItemDetailsResponseDto

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ItemDetailsScreen(
    modifier: Modifier = Modifier,
    vm: ItemDetailsViewModel,
    id: Int? = -1,
    navHostController: NavHostController

) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        vm.getItemDetails(id ?: -1)
    }
    LaunchedEffect(vm.errorMessage) {
        if (vm.errorMessage.isNotBlank()) {
            when (vm.errorMessage) {
                "No Internet Connection" -> {
                    Toast.makeText(
                        context,
                        context.getString(R.string.no_internet_connection),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    Toast.makeText(
                        context,
                        vm.errorMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
            vm.errorMessage = ""
        }
    }
    LoadingDialog(vm.isLoading)
    val itemDetails = vm.itemDetails.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.3f),
        ) {
            val (itemImage, closeIcon, shareIcon) = createRefs()
            GlideImage(
                model = IMAGE_URL + itemDetails?.image,
                contentDescription = "item image",
                modifier = Modifier
                    .fillMaxSize()
                    .constrainAs(itemImage) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentScale = ContentScale.FillBounds
            )

            Box(
                modifier = Modifier
                    .size(28.dp)
                    .background(Color.Black)
                    .clickable(interactionSource = null, indication = null) {
                        navHostController.popBackStack()
                    }
                    .constrainAs(closeIcon) {
                        top.linkTo(itemImage.top, margin = 20.dp)
                        start.linkTo(itemImage.start, margin = 20.dp)
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "close icon",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }

            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = "share icon",
                tint = Color.Black,
                modifier = Modifier
                    .size(28.dp)
                    .clickable(interactionSource = null, indication = null) {
                        Toast
                            .makeText(context, "Share", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .constrainAs(shareIcon) {
                        top.linkTo(closeIcon.top)
                        end.linkTo(parent.end, margin = 20.dp)
                    }
            )
        }
        CustomSpacer(12)
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp)
        ) {


        }

    }
}