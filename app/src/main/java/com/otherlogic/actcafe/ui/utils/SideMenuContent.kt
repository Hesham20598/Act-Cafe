package com.otherlogic.actcafe.ui.utils

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.otherlogic.actcafe.HelperClass.setLocale
import com.otherlogic.actcafe.R
import com.otherlogic.actcafe.ui.screens.MainActivity.MainActivity
import com.otherlogic.actcafe.ui.screens.MainScreen.MainViewModel
import com.otherlogic.actcafe.ui.theme.OrangeColor

@Composable
 fun SideMenuContent(
    paddingValues: PaddingValues?,
    vm: MainViewModel,
    isArabic: Boolean
) {
    val context = LocalContext.current
    val drawerScreens = listOf(
        stringResource(R.string.profile),
        stringResource(R.string.orders),
        stringResource(R.string.about),
        stringResource(R.string.share)
    )
    Box(
        modifier = Modifier
            .fillMaxWidth(.7f)
            .background(Color.White)
            .fillMaxHeight()
    ) {
        Column(

            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        ) {
            Spacer(modifier = Modifier.height(paddingValues?.calculateTopPadding() ?: 0.dp))
            Image(
                painter = painterResource(R.drawable.act_logo_image),
                contentDescription = "act logo image",
            )
            CustomSpacer(30)

            Column(
                modifier = Modifier
                    .padding(horizontal = 30.dp)
            ) {

                drawerScreens.forEachIndexed { index, drawerScreen ->
                    Text(
                        text = drawerScreens[index],
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.clickable(
                            interactionSource = null,
                            indication = null
                        ) {
                            when (drawerScreen) {
                                context.getString(R.string.profile) -> {

                                }

                                context.getString(R.string.orders) -> {

                                }

                                context.getString(R.string.about) -> {

                                }

                                context.getString(R.string.share) -> {

                                }
                            }
                        }

                    )
                    CustomSpacer(20)
                }
            }

        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(bottom = paddingValues?.calculateBottomPadding() ?: 0.dp)
                .align(
                    Alignment.BottomCenter
                )
                .fillMaxHeight(.3f)
                .fillMaxWidth()
        ) {
            Card(
                shape = CircleShape,
                modifier = Modifier.fillMaxWidth(.7f),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(4.dp)
            )
            {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    Button(
                        onClick = {
                            context.setLocale("ar")
                            vm.saveCurrentLanguage("ar")
                            val intent = (context as Activity).intent
                            context.finish()
                            context.startActivity(intent)

                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isArabic) {
                                OrangeColor
                            } else {
                                Color.Transparent
                            }
                        )
                    ) {
                        Text(
                            text = "عربي",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = if (isArabic) {
                                    FontWeight.Normal
                                } else {
                                    FontWeight.Bold
                                },
                                color = if (isArabic) {
                                    Color.White
                                } else {
                                    Color.Black
                                }
                            ),
                        )
                    }


                    Button(
                        onClick = {
                            context.setLocale("en")
                            vm.saveCurrentLanguage("en")
                            val intent = (context as MainActivity).intent
                            context.finish()
                            context.startActivity(intent)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (!isArabic) {
                                OrangeColor
                            } else {
                                Color.Transparent
                            }
                        )
                    ) {
                        Text(
                            text = "ENG",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = if (!isArabic) {
                                    FontWeight.Normal
                                } else {
                                    FontWeight.Bold
                                },
                                color = if (!isArabic) {
                                    Color.White
                                } else {
                                    Color.Black
                                }
                            ),
                        )
                    }

                }
            }
            CustomSpacer(20)
            Image(
                painter = painterResource(R.drawable.checked_icon),
                contentDescription = "other logic logo image",
                modifier = Modifier.size(30.dp)
            )
        }
    }
}
