package com.otherlogic.domain.usecases.settings

import com.otherlogic.domain.repositories.settings.SettingsRepository
import javax.inject.Inject

class SaveCartItemCountUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke(count: Int) = settingsRepository.saveCartItemsCount(count)
}