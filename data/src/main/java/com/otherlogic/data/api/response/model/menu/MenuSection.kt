package com.otherlogic.data.api.response.model.menu


import com.google.gson.annotations.SerializedName
import com.otherlogic.domain.entity.menu.MenuSectionDto

data class MenuSection(
    @SerializedName("arrangement")
    val arrangement: Any?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("deleted_at")
    val deletedAt: Any?,
    @SerializedName("description_ar")
    val descriptionAr: String?,
    @SerializedName("description_en")
    val descriptionEn: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("items")
    val items: List<MenuItem>?,
    @SerializedName("menu_id")
    val menuId: Int?,
    @SerializedName("name_ar")
    val nameAr: String?,
    @SerializedName("name_en")
    val nameEn: String?,
    @SerializedName("parent")
    val parent: Int?,
    @SerializedName("sections")
    val sections: List<Any>?,
    @SerializedName("status")
    val status: Int?,
    @SerializedName("updated_at")
    val updatedAt: String?
){
    fun toDto():MenuSectionDto = MenuSectionDto(
        arrangement = arrangement,
        created_at = createdAt,
        deleted_at = deletedAt,
        description_ar = descriptionAr,
        description_en = descriptionEn,
        id = id,
        image = image,
        items = items?.map { it.toDto() },
        menu_id = menuId,
        name_ar = nameAr,
        name_en = nameEn,
        parent = parent,
        sections = sections,
        status = status,
        updated_at = updatedAt
    )
}