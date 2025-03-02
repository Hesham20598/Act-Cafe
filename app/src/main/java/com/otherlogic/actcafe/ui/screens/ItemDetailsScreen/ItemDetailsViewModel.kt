package com.otherlogic.actcafe.ui.screens.ItemDetailsScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otherlogic.domain.entity.itemDetails.ItemDetailsResponseDto
import com.otherlogic.domain.usecases.itemDetials.GetItemDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class ItemDetailsViewModel @Inject constructor(
    private val getItemDetailsUseCase: GetItemDetailsUseCase
) : ViewModel() {
    private val _itemDetails = MutableLiveData<ItemDetailsResponseDto>()
    val itemDetails: LiveData<ItemDetailsResponseDto> = _itemDetails
    var isLoading by mutableStateOf(false)
    var errorMessage by mutableStateOf("")
    fun getItemDetails(id: Int) {
        viewModelScope.launch {
            isLoading = true
            try {
                _itemDetails.value = withContext(Dispatchers.IO) {
                    getItemDetailsUseCase(id)
                }
            } catch (e: IOException) {
                errorMessage = "No Internet Connection"
            } catch (e: Exception) {
                errorMessage = e.message.toString()
                Log.e("TAG", e.message.toString())
            } finally {
                isLoading = false
            }
        }
    }
}