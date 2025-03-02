package com.otherlogic.data.api.response.model.offers


import com.google.gson.annotations.SerializedName
import com.otherlogic.domain.entity.offer.OffersResponseDto

data class OffersResponse(
    @SerializedName("data")
    val `data`: OfferData?,
    @SerializedName("lang")
    val lang: String?,
    @SerializedName("response")
    val response: Boolean?
){
    fun toDto():OffersResponseDto = OffersResponseDto(
        data = data?.toDto(),
        lang = lang,
        response = response
    )
}