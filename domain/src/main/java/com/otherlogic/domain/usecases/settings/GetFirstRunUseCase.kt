package com.otherlogic.domain.usecases.settings

import com.otherlogic.domain.repositories.SettingsRepository
import javax.inject.Inject

class GetFirstRunUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke(): Boolean = settingsRepository.getFirstRun()
}