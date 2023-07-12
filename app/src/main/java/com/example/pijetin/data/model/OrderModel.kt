package com.example.pijetin.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OrderModel(
    val id: Int,
    val user_id: Int,
    val nama_lengkap: String,
    val gender: String,
    val durasi: String,
    val tambahan: String,
    val terapis: String?,
    val created_at: String,
    val status: String
)
