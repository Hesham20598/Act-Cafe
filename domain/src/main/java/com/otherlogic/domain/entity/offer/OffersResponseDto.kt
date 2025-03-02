package com.otherlogic.domain.entity.offer

data class OffersResponseDto(
    val `data`: OfferDataDto?,
    val lang: String?,
    val response: Boolean?
)