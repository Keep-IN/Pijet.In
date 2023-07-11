package com.example.pijetin.data.Api

import com.example.pijetin.data.Network.NetworkClient
import com.example.pijetin.data.Network.ResponseStatus
import com.example.pijetin.data.Network.deserializeJson
import com.example.pijetin.data.Network.mapFailedResponse
import com.example.pijetin.data.model.DataToken
import com.example.pijetin.data.model.User
import com.example.pijetin.data.model.UserDataResponse
import com.example.pijetin.data.model.UserList
import com.example.pijetin.data.model.UserLoginResponse
import com.example.pijetin.data.model.UserRegisResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import okhttp3.Call
import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class UsersAPI {
    private val usersEndpoint = "/users"
    private val loginEndpont = "/login"
    private val registerEndpoint = "/register"
    private val tokenEndpont = "/token"
    private val Base_Url = "http://45.32.103.75/v1/api"
    fun getUser(onResponse: (ResponseStatus<List<User>>) -> Unit) {
        val request = NetworkClient.requestBuilder(usersEndpoint, DataToken.token)
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

//                        JSONArray Adapter
//                        val moshi = Moshi.Builder().build()
//                        val adapter: JsonAdapter<List<User>> = moshi.adapter(Types.newParameterizedType(List::class.java, User::class.java))
//                        val userList = adapter.fromJson(response.body?.string() ?: "") ?: emptyList()

                        //JSON Object Adapter
                        val data = deserializeJson<UserList>(response.body?.string() ?: "") ?: UserList(404)
                        onResponse.invoke(
                            ResponseStatus.Success(
                                data = data.user,
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

    fun userLogin(email: String, password: String, onResponse: (ResponseStatus<UserLoginResponse?>) -> Unit) {
        val requestBody = FormBody.Builder()
            .add("email", email)
            .add("password", password)
            .build()
        val request = Request.Builder()
            .url("${Base_Url}${loginEndpont}")
            .post(requestBody)
            .build()

        NetworkClient
            .client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val responseData = response.body?.string() ?: ""
                    val moshi = Moshi.Builder().build()
                    val adapter: JsonAdapter<UserLoginResponse> = moshi.adapter(UserLoginResponse::class.java)
                    val user = adapter.fromJson(responseData)
                    onResponse.invoke(
                        ResponseStatus.Success(
                            data = user,
                            method = "POST",
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

    fun addUser(nama: String, no_telp: String, email: String, password: String, onResponse: (ResponseStatus<UserRegisResponse?>) -> Unit){
        val requestBody = FormBody.Builder()
            .add("nama", nama)
            .add("no_telp", no_telp)
            .add("email", email)
            .add("password", password)
            .build()
        val request = Request.Builder()
            .url("${Base_Url}${registerEndpoint}")
            .post(requestBody)
            .build()

        NetworkClient
            .client.newCall(request).enqueue(object : Callback {
                override fun onResponse(call: Call, response: Response) {
                    val responseData = response.body?.string() ?: ""
                    if (response.isSuccessful) {
                        try {
                            val moshi = Moshi.Builder().build()
                            val adapter: JsonAdapter<UserRegisResponse> = moshi.adapter(UserRegisResponse::class.java)
                            val user = adapter.fromJson(responseData)
                            onResponse.invoke(
                                ResponseStatus.Success(
                                    data = user,
                                    method = "POST",
                                    status = true
                                )
                            )
                        } catch (e: JsonDataException) {
                            onResponse.invoke(
                                ResponseStatus.Failed(
                                    code = response.code,
                                    message = "Error parsing response: ${e.message}",
                                    throwable = e
                                )
                            )
                        }
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

    fun getUserData(onResponse: (ResponseStatus<List<UserDataResponse>?>) -> Unit){
        val request = NetworkClient.getWithBearerToken(tokenEndpont,DataToken.token)
        NetworkClient
            .client.newCall(request)
            .enqueue(object : Callback {
                override fun onResponse(call: Call, response: Response) {
                    try{
//                        val responseBody = response.body?.string() ?: ""
                        val moshi = Moshi.Builder().build()
                        val adapter: JsonAdapter<List<UserDataResponse>> = moshi.adapter(Types.newParameterizedType(List::class.java, UserDataResponse::class.java))
                        val userList = adapter.fromJson(response.body?.string() ?: "") ?: emptyList()
                        if(response.isSuccessful){
                            onResponse.invoke(ResponseStatus.Success(
                                data = userList,
                                method = "GET",
                                status = true
                            ))
                        }
                        else {
                            onResponse.invoke(
                                mapFailedResponse(response)
                            )
                        }
                    } catch (e: IOException){
                        onResponse.invoke(
                            ResponseStatus.Failed(
                                code = -1,
                                message = e.message.toString(),
                                throwable = e
                            )
                        )
                    } finally {
                        response.close()
                    }
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

//    fun getError(onResponse: (ResponseStatus<Nothing>) -> Unit) {
//        NetworkClient
//            .client
//            .newCall(NetworkClient.requestBuilder("/unknown/23"))
//            .enqueue(object : Callback {
//                override fun onFailure(call: Call, e: IOException) {
//                    onResponse.invoke(ResponseStatus.Failed(-1, e.message.toString(), e))
//                }
//
//                override fun onResponse(call: Call, response: Response) {
//                    onResponse.invoke(ResponseStatus.Failed(-1, response.message))
//                    response.body?.close()
//                }
//            })
//    }

}