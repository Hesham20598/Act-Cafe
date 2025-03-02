package com.otherlogic.actcafe.ui.screens.CartScreen

import android.util.Log
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otherlogic.domain.entity.cartItem.CartItem
import com.otherlogic.domain.usecases.settings.GetCartItemCountUseCase
import com.otherlogic.domain.usecases.settings.SaveCartItemCountUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val saveCartItemCountUseCase: SaveCartItemCountUseCase,
    private val getCartItemCountUseCase: GetCartItemCountUseCase
) : ViewModel() {

//    init {
//        getCartItemCount()
//    }

    var cartItems = mutableStateListOf<CartItem>()
    var cartItemCount by mutableIntStateOf(0)
    fun addToCartItem(cartItem: CartItem) {
        viewModelScope.launch {
            cartItems.add(cartItem)
            cartItemCount++
            saveCartItemCountUseCase(cartItemCount)
        }
    }

    fun clearCartItems() {
        viewModelScope.launch {
            cartItems.clear()
            cartItemCount = 0
            saveCartItemCountUseCase(0)
        }
    }

    fun getCartItemCount() {
        viewModelScope.launch {
            cartItemCount = getCartItemCountUseCase()
        }
    }

}

