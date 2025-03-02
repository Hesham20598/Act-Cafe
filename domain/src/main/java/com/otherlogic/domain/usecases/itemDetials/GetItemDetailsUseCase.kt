package com.otherlogic.domain.usecases.itemDetials

import com.otherlogic.domain.entity.itemDetails.ItemDetailsResponseDto
import com.otherlogic.domain.repositories.itemDetails.ItemDetailsRepository
import javax.inject.Inject

class GetItemDetailsUseCase @Inject constructor(
    private val itemDetailsRepository: ItemDetailsRepository
) {
    suspend operator fun invoke(id: Int): ItemDetailsResponseDto = try {
        itemDetailsRepository.getItemDetails(id)
    } catch (e: Exception) {
        throw e
    }
}