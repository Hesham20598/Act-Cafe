package com.otherlogic.domain.usecases.settings

import com.otherlogic.domain.repositories.settings.SettingsRepository
import javax.inject.Inject

class SaveFirstRunUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke(state: Boolean) {
        settingsRepository.saveFirstRun(state)
    }
}