package com.otherlogic.data.api.response.model.offers


import com.google.gson.annotations.SerializedName
import com.otherlogic.domain.entity.offer.OfferDataDto

data class OfferData(
    @SerializedName("offers")
    val offers: List<OfferItem>?
){
    fun toDto():OfferDataDto = OfferDataDto(
        offers = offers?.map { it.toDto() }
    )
}