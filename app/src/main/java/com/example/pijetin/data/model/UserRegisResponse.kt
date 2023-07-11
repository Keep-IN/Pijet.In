package com.example.pijetin.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserRegisResponse(
    val status: Int,
    val message: String
)
