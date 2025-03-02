package com.otherlogic.domain.entity.menu

data class MenuInfoDto(
    val arrangement: Any?,
    val combo_item_code: Any?,
    val created_at: String?,
    val deleted_at: Any?,
    val extras: Any?,
    val id: Int?,
    val image: String?,
    val item_code: String?,
    val menu_item_id: Any?,
    val offer_price_ar: String?,
    val offer_price_en: String?,
    val old_price_ar: String?,
    val old_price_en: String?,
    val price: MenuPriceDto?,
    val price_ar: String?,
    val price_en: String?,
    val size_ar: String?,
    val size_en: String?,
    val status: String?,
    val updated_at: String?
)