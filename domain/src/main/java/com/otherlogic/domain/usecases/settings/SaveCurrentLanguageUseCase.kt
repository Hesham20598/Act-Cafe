package com.otherlogic.domain.usecases.settings

import com.otherlogic.domain.repositories.SettingsRepository
import javax.inject.Inject

class SaveCurrentLanguageUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository

) {
    suspend operator fun invoke(language: String) {
        settingsRepository.saveCurrentLanguage(language)
    }
}