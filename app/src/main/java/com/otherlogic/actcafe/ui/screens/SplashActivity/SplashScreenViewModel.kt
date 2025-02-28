package com.otherlogic.actcafe.ui.screens.SplashActivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otherlogic.domain.usecases.settings.GetFirstRunUseCase
import com.otherlogic.domain.usecases.settings.SaveCurrentLanguageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val getFirstRunUseCase: GetFirstRunUseCase,
    private val saveCurrentLanguageUseCase: SaveCurrentLanguageUseCase
) : ViewModel() {

    suspend fun getFirstRun(): Boolean = withContext(Dispatchers.IO) {
        getFirstRunUseCase()
    }

    fun saveCurrentLanguage(language: String) = viewModelScope.launch {
        saveCurrentLanguageUseCase(language)
    }
}

