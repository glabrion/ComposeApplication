package ru.sulatskov.composeapplication.model.network.dto

class Photo(
    val id: String?,
    val urls: UrlsDTO?
)

class UrlsDTO(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String
)
