package com.example.pijetin.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserList(
    val status: Int,
    val user: List<User> = listOf()
)
