package com.otherlogic.domain.usecases.settings

import com.otherlogic.domain.repositories.SettingsRepository
import javax.inject.Inject

class GetCurrentLanguageUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke(): String {
        return settingsRepository.getCurrentLanguage()
    }
}