package com.otherlogic.domain.entity.itemDetails

data class ItemDetailsResponseDto(
    val arrangement: Any?,
    val created_at: String?,
    val deleted_at: Any?,
    val description_ar: String?,
    val description_en: String?,
    val extras: Any?,
    val extras_max_count: Int?,
    val id: Int?,
    val image: String?,
    val info: List<ItemDetailsInfoDto?>?,
    val item_extras: List<Any?>?,
    val menu_id: Int?,
    val name_ar: String?,
    val name_en: String?,
    val offer: String?,
    val offer_type: String?,
    val related: List<Any?>?,
    val section_id: Int?,
    val status: Int?,
    val updated_at: String?
)