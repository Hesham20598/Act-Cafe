package com.otherlogic.data.repositories.itemDetails

import com.otherlogic.data.api.ActServices
import com.otherlogic.domain.entity.itemDetails.ItemDetailsResponseDto
import com.otherlogic.domain.repositories.itemDetails.ItemDetailsRepository
import javax.inject.Inject

class ItemDetailsRepoImpl @Inject constructor(
    private val actServices: ActServices
):ItemDetailsRepository {

    override suspend fun getItemDetails(id: Int): ItemDetailsResponseDto {
        return actServices.getItemDetails(id).toDto()
    }
}