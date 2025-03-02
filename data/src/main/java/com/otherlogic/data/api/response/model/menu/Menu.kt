package com.otherlogic.data.api.response.model.menu


import com.google.gson.annotations.SerializedName
import com.otherlogic.domain.entity.menu.MenuDto

data class Menu(
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
    @SerializedName("name_ar")
    val nameAr: String?,
    @SerializedName("name_en")
    val nameEn: String?,
    @SerializedName("restaurant_id")
    val restaurantId: Int?,
    @SerializedName("sections")
    val sections: List<MenuSection>?,
    @SerializedName("status")
    val status: Int?,
    @SerializedName("updated_at")
    val updatedAt: String?
) {
    fun toDto(): MenuDto = MenuDto(
        created_at = createdAt,
        deleted_at = deletedAt,
        description_ar = descriptionAr,
        description_en = descriptionEn,
        id = id,
        image = image,
        name_ar = nameAr,
        name_en = nameEn,
        restaurant_id = restaurantId,
        sections = sections?.map { it.toDto() },
        status = status,
        updated_at = updatedAt

    )
}