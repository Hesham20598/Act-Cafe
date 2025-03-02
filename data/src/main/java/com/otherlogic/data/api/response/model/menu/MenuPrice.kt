package com.otherlogic.data.api.response.model.menu


import com.google.gson.annotations.SerializedName
import com.otherlogic.domain.entity.menu.MenuPriceDto

data class MenuPrice(
    @SerializedName("created_at")
    val createdAt: Any?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("item_id")
    val itemId: Int?,
    @SerializedName("price")
    val price: Int?,
    @SerializedName("price_list")
    val priceList: Int?,
    @SerializedName("updated_at")
    val updatedAt: Any?
) {
    fun toDto(): MenuPriceDto = MenuPriceDto(
        created_at = createdAt,
        id = id,
        item_id = itemId,
        price = price,
        price_list = priceList,
        updated_at = updatedAt
    )
}