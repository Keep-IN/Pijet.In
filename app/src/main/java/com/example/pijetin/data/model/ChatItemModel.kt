package com.example.pijetin.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChatItemModel(
    val fotopengguna: String,
    val namapengguna: String,
    val isichat: String,
    val waktu: String
) :Parcelable
