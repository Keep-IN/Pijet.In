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
    val noTelp: String = "",
    val nik: String? = "",
    val email: String = "",
    val password: String = "",
    val tglLahir: String? = "",
    val tempatLahir: String? = "",
    val imageUrl: String? = ""
) : Parcelable
