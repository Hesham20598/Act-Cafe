package com.otherlogic.actcafe.ui.screens.MenuScreen.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.otherlogic.actcafe.Screens
import com.otherlogic.actcafe.ui.screens.CartScreen.CartViewModel
import com.otherlogic.actcafe.ui.screens.MenuScreen.MenuViewModel
import com.otherlogic.actcafe.ui.utils.SectionItemDesign
import com.otherlogic.domain.entity.cartItem.CartItem

@Composable
fun MenuLazyColumn(
    modifier: Modifier = Modifier,
    vm: MenuViewModel,
    navController: NavHostController,
    cartViewModel: CartViewModel,
    isArabic: Boolean
) {
    val context = LocalContext.current
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
            .fillMaxWidth(.95f)
    ) {
        items(vm.sectionItems) { item ->
            SectionItemDesign(item = item, onItemClicked = {
                navController.navigate("${Screens.ITEM_DETAILS_SCREEN.name}/${item.id}")
//                Toast.makeText(context, item.id.toString(), Toast.LENGTH_SHORT).show()
            }) {
                // on add to cart button clicked ..

                cartViewModel.addToCartItem(
                    CartItem(
                        image = item.image ?: "",
                        name = if (isArabic) item.name_ar ?: "" else item.name_en ?: "",
                        price = item.info?.get(0)?.price?.price?.toDouble() ?: 0.0,
                        description = if (isArabic) item.description_ar
                            ?: "" else item.description_en ?: ""
                    )
                )
            }
        }
    }
}