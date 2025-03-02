package com.otherlogic.domain.entity.menu

data class MenuResponseDto(
    val `data`: MenuDataDto?,
    val lang: String?,
    val response: Boolean?
)