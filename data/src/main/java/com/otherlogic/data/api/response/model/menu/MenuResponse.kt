package com.otherlogic.data.api.response.model.menu


import com.google.gson.annotations.SerializedName
import com.otherlogic.domain.entity.menu.MenuResponseDto

data class MenuResponse(
    @SerializedName("data")
    val `data`: MenuData?,
    @SerializedName("lang")
    val lang: String?,
    @SerializedName("response")
    val response: Boolean?
){
    fun toDto():MenuResponseDto = MenuResponseDto(
        data = data?.toDto(),
        lang = lang,
        response = response
    )
}