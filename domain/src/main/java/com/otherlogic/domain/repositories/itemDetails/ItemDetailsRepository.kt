package com.otherlogic.domain.repositories.itemDetails

import com.otherlogic.domain.entity.itemDetails.ItemDetailsResponseDto

interface ItemDetailsRepository {
    suspend fun getItemDetails(id: Int): ItemDetailsResponseDto
}