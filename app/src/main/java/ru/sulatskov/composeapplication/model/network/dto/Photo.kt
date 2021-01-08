package ru.sulatskov.composeapplication.model.network.dto

import com.google.gson.annotations.SerializedName

class Photo(
    val id: String? = "",
    val urls: UrlsDTO? = UrlsDTO(),
    val description: String? = "",
    @SerializedName("created_at")
    val createdAt: String? = "",
    val likes: Int? = 0,
    val user: User? = User()
)

class User(
    val username: String = "",
    val name: String = "",
    @SerializedName("profile_image")
    val profileImage: ProfileImage = ProfileImage()
)

class ProfileImage(val medium: String = "")

class UrlsDTO(val regular: String? = null)
