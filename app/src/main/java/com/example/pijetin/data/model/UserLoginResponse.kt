package com.example.pijetin.data.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class UserLoginResponse(
    val status: Int = 0,
    val token: String? = "",
    val nama: String = "",
    val email: String = "",
    val image_url: String? = ""
): Parcelable