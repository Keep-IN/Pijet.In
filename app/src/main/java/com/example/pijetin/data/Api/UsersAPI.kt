package com.example.pijetin.data.Api

import com.example.pijetin.data.Network.NetworkClient
import com.example.pijetin.data.Network.ResponseStatus
import com.example.pijetin.data.Network.deserializeJson
import com.example.pijetin.data.Network.mapFailedResponse
import com.example.pijetin.data.model.User
import com.example.pijetin.data.model.UserList
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import org.json.JSONArray
import java.io.IOException

class UsersAPI {
    private val usersEndpoint = "/users"
    fun getUser(onResponse: (ResponseStatus<List<User>>) -> Unit) {
        val request = NetworkClient.requestBuilder(usersEndpoint)
        NetworkClient
            .client
            .newCall(request)
            .enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    onResponse.invoke(
                        ResponseStatus.Failed(
                            code = -1,
                            message = e.message.toString(),
                            throwable = e
                        )
                    )
                }
                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {
                        val moshi = Moshi.Builder().build()
                        val adapter: JsonAdapter<List<User>> = moshi.adapter(Types.newParameterizedType(List::class.java, User::class.java))
                        val userList = adapter.fromJson(response.body?.string() ?: "") ?: emptyList()
                        onResponse.invoke(
                            ResponseStatus.Success(
                                data = userList,
                                method = "GET",
                                status = true
                            )
                        )
                    } else {
                        onResponse.invoke(
                            mapFailedResponse(response)
                        )
                    }
                    response.body?.close()
                }
            })
    }

    fun getError(onResponse: (ResponseStatus<Nothing>) -> Unit) {
        NetworkClient
            .client
            .newCall(NetworkClient.requestBuilder("/unknown/23"))
            .enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    onResponse.invoke(ResponseStatus.Failed(-1, e.message.toString(), e))
                }

                override fun onResponse(call: Call, response: Response) {
                    onResponse.invoke(ResponseStatus.Failed(-1, response.message))
                    response.body?.close()
                }
            })
    }
}