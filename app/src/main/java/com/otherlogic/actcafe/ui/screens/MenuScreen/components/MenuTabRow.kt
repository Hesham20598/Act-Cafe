package com.otherlogic.actcafe.ui.screens.MenuScreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.otherlogic.actcafe.ui.screens.MenuScreen.MenuViewModel
import com.otherlogic.actcafe.ui.theme.OrangeColor

@Composable
fun MenuTabRow(
    vm: MenuViewModel,
    isArabic: Boolean
) {
    if (vm.sections.isNotEmpty()) {
        if (vm.sections.size <= 3) {
            TabRow(
                divider = {},
                indicator = { tabPositions ->
                    SecondaryIndicator(
                        modifier = Modifier
                            .tabIndicatorOffset(tabPositions[vm.selectedSectionTabIndex]),
                        color = OrangeColor // Change the indicator color here
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                selectedTabIndex = vm.selectedSectionTabIndex,
                containerColor = Color.White.copy(.2f)
            ) {
                vm.sections.forEachIndexed { index, menuSectionDto ->
                    Tab(
                        selected = index == vm.selectedSectionTabIndex,
                        interactionSource = null,
                        onClick = {
                            vm.selectedSectionTabIndex = index
                            vm.updateSelectedSectionItems()
                        }) {
                        Card(
                            modifier = Modifier
                                .width(100.dp)
                                .padding(bottom = 12.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White
                            ),
                            elevation = CardDefaults.cardElevation(4.dp)
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 12.dp),
                                text = if (isArabic) menuSectionDto.name_ar
                                    ?: "" else menuSectionDto.name_en ?: "",
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    }
                }
            }
        } else {

            ScrollableTabRow(
                edgePadding = 12.dp,
                divider = {},
                indicator = { tabPositions ->
                    SecondaryIndicator(
                        modifier = Modifier
                            .tabIndicatorOffset(tabPositions[vm.selectedSectionTabIndex]),
                        color = OrangeColor // Change the indicator color here
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(),
                selectedTabIndex = vm.selectedSectionTabIndex,
                containerColor = Color.White.copy(.2f)
            ) {
                vm.sections.forEachIndexed { index, menuSectionDto ->
                    Tab(modifier = if (index == vm.sections.lastIndex) Modifier.padding(end = 25.dp) else Modifier.padding(end =
                        20.dp
                    ),
                        selected = index == vm.selectedSectionTabIndex,
                        onClick = {
                            vm.selectedSectionTabIndex = index
                            vm.updateSelectedSectionItems()
                        }) {
                        Card(
                            modifier = Modifier
                                .width(100.dp)
                                .padding(bottom = 12.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White
                            ),
                            elevation = CardDefaults.cardElevation(4.dp)
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 12.dp),
                                text = if (isArabic) menuSectionDto.name_ar
                                    ?: "" else menuSectionDto.name_en ?: "",
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}