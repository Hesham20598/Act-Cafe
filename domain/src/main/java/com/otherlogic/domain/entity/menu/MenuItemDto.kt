package com.otherlogic.domain.entity.menu

data class MenuItemDto(
    val arrangement: Any?,
    val created_at: String?,
    val deleted_at: Any?,
    val description_ar: String?,
    val description_en: String?,
    val extras: Any?,
    val extras_max_count: Int?,
    val id: Int?,
    val image: String?,
    val info: List<MenuInfoDto?>?,
    val menu_id: Int?,
    val name_ar: String?,
    val name_en: String?,
    val offer: String?,
    val offer_type: String?,
    val section_id: Int?,
    val status: Int?,
    val updated_at: String?
)