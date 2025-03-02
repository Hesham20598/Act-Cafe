package com.otherlogic.data.repositories.menu

import com.otherlogic.data.api.ActServices
import com.otherlogic.domain.entity.menu.MenuResponseDto
import com.otherlogic.domain.entity.offer.OffersResponseDto
import com.otherlogic.domain.repositories.menu.MenuRepository
import javax.inject.Inject

class MenuRepoImpl @Inject constructor(
    private val actServices: ActServices
) : MenuRepository {
    override suspend fun getMenu(): MenuResponseDto {
        return actServices.getMenu().toDto()
    }

    override suspend fun getOffers(): OffersResponseDto {
        return actServices.getOffers().toDto()
    }
}