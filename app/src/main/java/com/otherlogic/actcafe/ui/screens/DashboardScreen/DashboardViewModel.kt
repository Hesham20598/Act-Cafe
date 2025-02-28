package com.otherlogic.actcafe.ui.screens.DashboardScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otherlogic.domain.usecases.settings.GetFirstRunUseCase
import com.otherlogic.domain.usecases.settings.SaveFirstRunUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val saveFirstRunUseCase: SaveFirstRunUseCase
) : ViewModel() {

    fun saveFirstRun(firstRun: Boolean) {
        viewModelScope.launch {
            saveFirstRunUseCase(firstRun)
        }
    }


}