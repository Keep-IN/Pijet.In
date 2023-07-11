package com.example.pijetin.data.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class User(
    val id: Int = 0,
    val nama: String = "",
    val status: String = "",
    val no_telp: String = "",
    val nik: String? = "",
    val email: String = "",
    val password: String = "",
    val tanggal_lahir: String? = "",
    val tempat_lahir: String? = "",
    val image_url: String? = ""
) : Parcelable
