package com.otherlogic.actcafe.ui.screens.MainScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otherlogic.domain.usecases.settings.GetCartItemCountUseCase
import com.otherlogic.domain.usecases.settings.SaveCartItemCountUseCase
import com.otherlogic.domain.usecases.settings.SaveCurrentLanguageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val saveCurrentLanguageUseCase: SaveCurrentLanguageUseCase,
) : ViewModel() {
    var appBarState by mutableStateOf("")
    fun saveCurrentLanguage(language: String) = viewModelScope.launch {
        saveCurrentLanguageUseCase(language)
    }
}
