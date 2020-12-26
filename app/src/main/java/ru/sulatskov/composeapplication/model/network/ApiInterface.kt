package ru.sulatskov.composeapplication.model.network

import retrofit2.http.GET


interface ApiInterface {

    @GET("")
    suspend fun getList()
}