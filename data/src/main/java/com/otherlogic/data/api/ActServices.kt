package com.otherlogic.data.api

import com.otherlogic.data.api.response.model.itemDetails.ItemDetailsResponse
import com.otherlogic.data.api.response.model.menu.MenuResponse
import com.otherlogic.data.api.response.model.offers.OffersResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ActServices {

    @GET("menu/1/1")
    suspend fun getMenu(): MenuResponse

    @GET("offers/1/1")
    suspend fun getOffers(): OffersResponse

    @GET("item/{id}/1")
    suspend fun getItemDetails(
        @Path("id") id: Int
    ): ItemDetailsResponse


}