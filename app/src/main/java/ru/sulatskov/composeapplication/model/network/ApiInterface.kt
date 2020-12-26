package ru.sulatskov.composeapplication.model.network

import retrofit2.http.GET
import retrofit2.http.Query
import ru.sulatskov.composeapplication.common.AppConst
import ru.sulatskov.composeapplication.model.network.dto.Photo


interface ApiInterface {
    @GET("photos")
    suspend fun getListPhotos(
        @Query("page") page: Int?,
        @Query("client_id") clientId: String = AppConst.ACCESS_KEY
    ): List<Photo>
}