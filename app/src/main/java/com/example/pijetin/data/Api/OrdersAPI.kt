package com.example.pijetin.data.Api

import com.example.pijetin.data.Network.NetworkClient
import com.example.pijetin.data.Network.ResponseStatus
import com.example.pijetin.data.Network.deserializeJson
import com.example.pijetin.data.Network.mapFailedResponse
import com.example.pijetin.data.model.DataToken
import com.example.pijetin.data.model.OrderList
import com.example.pijetin.data.model.OrderModel
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

class OrdersAPI {
    private val Base_Url = "http://45.32.103.75/v1/api"
    private val orderEndpoint = "/orders"

    fun getOrder(onResponse: (ResponseStatus<List<OrderModel>>) -> Unit){
        val request = NetworkClient.getWithBearerToken(orderEndpoint, DataToken.token)
        NetworkClient
            .client.newCall(request)
            .enqueue(object : Callback{
                override fun onResponse(call: Call, response: Response) {
                    val data = deserializeJson<OrderList>(response.body?.string() ?: "") ?: OrderList(404)
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

}