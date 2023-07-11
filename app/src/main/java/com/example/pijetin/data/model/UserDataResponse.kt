package com.example.pijetin.data.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class UserDataResponse (
    val id: Int,
    val nama: String,
    val nik: String?,
    val status: String,
    val email: String,
    val tanggal_lahir: String?,
    val tempat_lahir: String?,
    val image_url: String?,
    val remember_me_token: String?,
    ) : Parcelable