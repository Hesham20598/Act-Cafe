package com.otherlogic.actcafe.ui.screens.CartScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CartViewModel:ViewModel() {
    var cartItemsCount by mutableIntStateOf(0)
}