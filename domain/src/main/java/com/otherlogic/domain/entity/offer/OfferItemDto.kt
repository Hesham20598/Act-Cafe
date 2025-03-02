package com.otherlogic.domain.entity.offer

data class OfferItemDto(
    val arrangement: Any?,
    val created_at: String?,
    val deleted_at: Any?,
    val description_ar: String?,
    val description_en: String?,
    val extras: Any?,
    val extras_max_count: Int?,
    val id: Int?,
    val image: String?,
    val info: List<OfferInfoDto?>?,
    val menu_id: Int?,
    val name_ar: String?,
    val name_en: String?,
    val offer: Int?,
    val offer_type: String?,
    val section_id: Int?,
    val status: Int?,
    val updated_at: String?
)