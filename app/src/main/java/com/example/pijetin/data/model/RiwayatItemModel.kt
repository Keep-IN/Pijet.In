package com.example.pijetin.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RiwayatItemModel(
    val id: String,
    val title: String,
    val terapis: String,
    val date: String,
    val status: String
) :Parcelable
