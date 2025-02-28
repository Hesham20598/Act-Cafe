package com.otherlogic.actcafe.ui.screens.LanguageScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otherlogic.domain.usecases.settings.SaveCurrentLanguageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LanguageScreenViewModel @Inject constructor(
    private val saveCurrentLanguageUseCase: SaveCurrentLanguageUseCase
) : ViewModel() {

    fun saveCurrentLanguage(language: String) = viewModelScope.launch {
        saveCurrentLanguageUseCase(language)
    }

}