package com.otherlogic.data.api.response.model.offers


import com.google.gson.annotations.SerializedName
import com.otherlogic.domain.entity.offer.OfferItemDto

data class OfferItem(
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
    val info: List<OfferInfo>?,
    @SerializedName("menu_id")
    val menuId: Int?,
    @SerializedName("name_ar")
    val nameAr: String?,
    @SerializedName("name_en")
    val nameEn: String?,
    @SerializedName("offer")
    val offer: Int?,
    @SerializedName("offer_type")
    val offerType: String?,
    @SerializedName("section_id")
    val sectionId: Int?,
    @SerializedName("status")
    val status: Int?,
    @SerializedName("updated_at")
    val updatedAt: String?
){
    fun toDto(): OfferItemDto = OfferItemDto(
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
        menu_id = menuId,
        name_ar = nameAr,
        name_en = nameEn,
        offer = offer,
        offer_type = offerType,
        section_id = sectionId,
        status = status,
        updated_at = updatedAt
    )
}