package ru.sulatskov.composeapplication.model.network.dto

import com.google.gson.annotations.SerializedName

class Photo(
    val id: String? = "",
    val urls: UrlsDTO? = UrlsDTO(),
    val description: String? = "",
    val altDescription: String? = "",
    @SerializedName("created_at")
    val createdAt: String? = ""
)

class UrlsDTO(val regular: String? = "")
