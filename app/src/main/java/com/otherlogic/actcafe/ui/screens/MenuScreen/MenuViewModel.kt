package com.otherlogic.actcafe.ui.screens.MenuScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otherlogic.actcafe.HelperClass.IMAGE_URL
import com.otherlogic.domain.entity.menu.MenuItemDto
import com.otherlogic.domain.entity.menu.MenuSectionDto
import com.otherlogic.domain.entity.offer.OfferItemDto
import com.otherlogic.domain.usecases.menu.GetMenuUseCase
import com.otherlogic.domain.usecases.menu.GetOffersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val getMenuUseCase: GetMenuUseCase,
    private val getOffersUseCase: GetOffersUseCase,
) : ViewModel() {
    val TAG = "TAG"
    var isLoading by mutableStateOf(false)
    val sections = mutableStateListOf<MenuSectionDto>()
    val sectionItems = mutableStateListOf<MenuItemDto>()
    val offers = mutableStateListOf<OfferItemDto>()
    var selectedSectionTabIndex by mutableIntStateOf(0)
    var errorMessage by mutableStateOf("")
    var responseMessage by mutableStateOf("")

    val images = mutableStateListOf<String>()

    fun getOffers() {
        viewModelScope.launch {
            isLoading = true
            try {
                val response = withContext(Dispatchers.IO) {
                    getOffersUseCase()
                }
                if (response.response == true) {
                    offers.clear()
                    offers.addAll(response.data?.offers ?: emptyList())
                    images.clear()
                    offers.forEach {
                        images.add(IMAGE_URL + it.image)
                    }
                } else {
                    errorMessage = "response is false"
                }
            } catch (e: IOException) {
                errorMessage = "No Internet Connection"
            } catch (e: Exception) {
                errorMessage = e.message.toString()
                Log.e(TAG, "getOffers: exception is ${e.message}")
            } finally {
                isLoading = false
            }
        }

    }

    fun getMenu() {
        viewModelScope.launch {
            isLoading = true
            try {
                val response = withContext(Dispatchers.IO) {
                    getMenuUseCase()
                }
                sections.clear()
                sectionItems.clear()
                if (response.response == true) {
                    sections.addAll(response.data?.menu?.get(0)?.sections ?: emptyList())
                    sectionItems.addAll(
                        response.data?.menu?.get(0)?.sections?.get(
                            selectedSectionTabIndex
                        )?.items ?: emptyList()
                    )
                } else {
                    errorMessage = "response is false"
                }
            } catch (e: IOException) {
                errorMessage = "No Internet Connection"
            } catch (e: Exception) {
                errorMessage = e.message.toString()
                Log.e(TAG, "getMenu: exception is ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }

    fun updateSelectedSectionItems() {
        sectionItems.clear()
        sectionItems.addAll(sections[selectedSectionTabIndex].items ?: emptyList())
    }


}