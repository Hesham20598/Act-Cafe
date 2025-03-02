package com.otherlogic.data.api.response.model.menu


import com.google.gson.annotations.SerializedName
import com.otherlogic.domain.entity.menu.MenuDataDto

data class MenuData(
    @SerializedName("menu")
    val menu: List<Menu>?
){
    fun toDto():MenuDataDto = MenuDataDto(
        menu = menu?.map { it.toDto() }
    )
}