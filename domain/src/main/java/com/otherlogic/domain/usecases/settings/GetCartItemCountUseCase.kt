package com.otherlogic.domain.usecases.settings

import com.otherlogic.domain.repositories.settings.SettingsRepository
import javax.inject.Inject

class GetCartItemCountUseCase @Inject constructor(
    private val settingsResult: SettingsRepository
) {
    suspend operator fun invoke(): Int = settingsResult.getCartItemsCount()
}