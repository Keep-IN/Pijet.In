package com.example.pijetin.data.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class UserLoginResponse(
    val uuid: String,
    val email: String,
    val nama: String
): Parcelable