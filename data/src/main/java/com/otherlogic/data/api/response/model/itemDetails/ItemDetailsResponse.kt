package com.otherlogic.data.api.response.model.itemDetails


import com.google.gson.annotations.SerializedName
import com.otherlogic.domain.entity.itemDetails.ItemDetailsResponseDto

data class ItemDetailsResponse(
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
    @SerializedName("extras")
    val extras: Any?,
    @SerializedName("extras_max_count")
    val extrasMaxCount: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("info")
    val info: List<ItemDetailsInfo>?,
    @SerializedName("item_extras")
    val itemExtras: List<Any?>?,
    @SerializedName("menu_id")
    val menuId: Int?,
    @SerializedName("name_ar")
    val nameAr: String?,
    @SerializedName("name_en")
    val nameEn: String?,
    @SerializedName("offer")
    val offer: String?,
    @SerializedName("offer_type")
    val offerType: String?,
    @SerializedName("related")
    val related: List<Any?>?,
    @SerializedName("section_id")
    val sectionId: Int?,
    @SerializedName("status")
    val status: Int?,
    @SerializedName("updated_at")
    val updatedAt: String?
){
    fun toDto():ItemDetailsResponseDto = ItemDetailsResponseDto(
        arrangement = arrangement,
        created_at = createdAt,
        deleted_at = deletedAt,
        description_ar = descriptionAr,
        description_en = descriptionEn,
        extras = extras,
        extras_max_count = extrasMaxCount,
        id = id,
        image = image,
        info = info?.map { it.toDto() },
        item_extras = itemExtras,
        menu_id = menuId,
        name_ar = nameAr,
        name_en = nameEn,
        offer = offer,
        offer_type = offerType,
        related = related,
        section_id = sectionId,
        status = status,
        updated_at = updatedAt
    )
}