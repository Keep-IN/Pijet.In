package com.example.pijetin.data.Api

import com.example.pijetin.data.Network.MoshiExtension.moshi
import com.example.pijetin.data.Network.NetworkClient
import com.example.pijetin.data.Network.ResponseStatus
import com.example.pijetin.data.Network.deserializeJson
import com.example.pijetin.data.Network.mapFailedResponse
import com.example.pijetin.data.model.DataToken
import com.example.pijetin.data.model.OrderList
import com.example.pijetin.data.model.OrderModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import okhttp3.Call
import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class OrdersAPI {
    private val Base_Url = "www.youtube.com"
    private val orderEndpoint = "/home"

    fun getOrder(onResponse: (ResponseStatus<List<OrderModel>>) -> Unit){
        val request = NetworkClient.getWithBearerToken(orderEndpoint, DataToken.token)
        NetworkClient
            .client.newCall(request)
            .enqueue(object : Callback{
                override fun onResponse(call: Call, response: Response) {
                    val data = deserializeJson<OrderList>(response.body?.string() ?: "") ?: OrderList()
                    if (response.isSuccessful){
                        onResponse.invoke(ResponseStatus.Success(
                            data = data.orderList,
                            method = "GET",
                            status = true
                        ))
                    }
                    else {
                        onResponse.invoke(
                            mapFailedResponse(response)
                        )
                    }
                    response.body?.close()
                }
                override fun onFailure(call: Call, e: IOException) {
                    onResponse.invoke(
                        ResponseStatus.Failed(
                            code = -1,
                            message = e.message.toString(),
                            throwable = e
                        )
                    )
                }
            })
    }

    fun addOrder(nama: String, gender: String, durasi: String, tambahan: String, tanggal: String, harga: String, jam: String, token: String,
                  onResponse: (ResponseStatus<OrderList>) -> Unit){
        val requestBody = FormBody.Builder()
            .add("nama_lengkap", nama)
            .add("gender", gender)
            .add("durasi", durasi)
            .add("tambahan", tambahan)
            .add("tanggal_pesanan", tanggal)
            .add("harga", harga)
            .add("jam", jam)
            .build()
        val request = Request.Builder()
            .url("${Base_Url}${orderEndpoint}")
            .header("Authorization", "Bearer $token")
            .post(requestBody)
            .build()

        NetworkClient
            .client.newCall(request).enqueue((object: Callback{
                override fun onResponse(call: Call, response: Response) {
                    val responseData = response.body?.string() ?: ""
                    if(response.isSuccessful){
                        val moshi = Moshi.Builder().build()
                        val adapter: JsonAdapter<OrderList> = moshi.adapter(OrderList::class.java)
                        val order = adapter.fromJson(responseData)
                        if (order != null){
                            onResponse.invoke(
                                ResponseStatus.Success(
                                    data = order,
                                    method = "POST",
                                    status = true
                                )
                            )
                        }
                    } else {
                        onResponse.invoke(
                            mapFailedResponse(response)
                        )
                    }
                    response.body?.close()
                }

                override fun onFailure(call: Call, e: IOException) {
                    onResponse.invoke(
                        ResponseStatus.Failed(
                            code = -1,
                            message = e.message.toString(),
                            throwable = e
                        )
                    )
                }

            }))
    }

}