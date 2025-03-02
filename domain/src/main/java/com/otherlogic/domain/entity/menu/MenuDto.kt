package com.otherlogic.domain.entity.menu

data class MenuDto(
    val created_at: String?,
    val deleted_at: Any?,
    val description_ar: String?,
    val description_en: String?,
    val id: Int?,
    val image: String?,
    val name_ar: String?,
    val name_en: String?,
    val restaurant_id: Int?,
    val sections: List<MenuSectionDto>?,
    val status: Int?,
    val updated_at: String?
)