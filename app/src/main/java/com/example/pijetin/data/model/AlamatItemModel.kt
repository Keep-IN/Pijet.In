package com.example.pijetin.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AlamatItemModel(
    val judul: String,
    val alamat: String,
) :Parcelable
