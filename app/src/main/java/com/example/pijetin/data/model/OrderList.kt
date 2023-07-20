package com.example.pijetin.data.model

import androidx.lifecycle.GeneratedAdapter
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OrderList(
    val status: Int = 0,
    val msg: String = "",
    val orderList: List<OrderModel> = listOf()
)
