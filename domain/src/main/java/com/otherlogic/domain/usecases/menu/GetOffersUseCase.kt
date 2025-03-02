package com.otherlogic.domain.usecases.menu

import com.otherlogic.domain.entity.offer.OffersResponseDto
import com.otherlogic.domain.repositories.menu.MenuRepository
import javax.inject.Inject

class GetOffersUseCase @Inject constructor(
    private val menuRepository: MenuRepository
) {
    suspend operator fun invoke(): OffersResponseDto = try {
        menuRepository.getOffers()
    } catch (e: Exception) {
        throw e
    }
}