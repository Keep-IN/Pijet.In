package com.example.pijetin.data.model

data class OrderList(
    val status: Int,
    val orderList: List<OrderModel> = listOf()
)
