package com.otherlogic.domain.repositories.menu

import com.otherlogic.domain.entity.menu.MenuResponseDto
import com.otherlogic.domain.entity.offer.OffersResponseDto

interface MenuRepository {

    suspend fun getMenu(): MenuResponseDto
    suspend fun getOffers(): OffersResponseDto


}