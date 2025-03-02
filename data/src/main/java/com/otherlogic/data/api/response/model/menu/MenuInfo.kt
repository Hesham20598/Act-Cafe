package com.otherlogic.data.api.response.model.menu


import com.google.gson.annotations.SerializedName
import com.otherlogic.domain.entity.menu.MenuInfoDto

data class MenuInfo(
    @SerializedName("arrangement")
    val arrangement: Any?,
    @SerializedName("combo_item_code")
    val comboItemCode: Any?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("deleted_at")
    val deletedAt: Any?,
    @SerializedName("extras")
    val extras: Any?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("item_code")
    val itemCode: String?,
    @SerializedName("menu_item_id")
    val menuItemId: Any?,
    @SerializedName("offer_price_ar")
    val offerPriceAr: String?,
    @SerializedName("offer_price_en")
    val offerPriceEn: String?,
    @SerializedName("old_price_ar")
    val oldPriceAr: String?,
    @SerializedName("old_price_en")
    val oldPriceEn: String?,
    @SerializedName("price")
    val price: MenuPrice?,
    @SerializedName("price_ar")
    val priceAr: String?,
    @SerializedName("price_en")
    val priceEn: String?,
    @SerializedName("size_ar")
    val sizeAr: String?,
    @SerializedName("size_en")
    val sizeEn: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("updated_at")
    val updatedAt: String?
){
    fun toDto():MenuInfoDto = MenuInfoDto(
        arrangement = arrangement,
        combo_item_code = comboItemCode,
        created_at = createdAt,
        deleted_at = deletedAt,
        extras = extras,
        id = id,
        image = image,
        item_code = itemCode,
        menu_item_id = menuItemId,
        offer_price_ar = offerPriceAr,
        offer_price_en = offerPriceEn,
        old_price_ar = oldPriceAr,
        old_price_en = oldPriceEn,
        price = price?.toDto(),
        price_ar = priceAr,
        price_en = priceEn,
        size_ar = sizeAr,
        size_en = sizeEn,
        status = status,
        updated_at = updatedAt

    )
}