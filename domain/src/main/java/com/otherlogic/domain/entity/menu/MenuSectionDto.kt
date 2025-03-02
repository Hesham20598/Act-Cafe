package com.otherlogic.domain.entity.menu

data class MenuSectionDto(
    val arrangement: Any?,
    val created_at: String?,
    val deleted_at: Any?,
    val description_ar: String?,
    val description_en: String?,
    val id: Int?,
    val image: String?,
    val items: List<MenuItemDto>?,
    val menu_id: Int?,
    val name_ar: String?,
    val name_en: String?,
    val parent: Int?,
    val sections: List<Any?>?,
    val status: Int?,
    val updated_at: String?
)