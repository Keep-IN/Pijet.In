package com.example.pijetin.feature.Dashboard

import com.example.pijetin.data.model.UserDataResponse

interface HomeContract {
    fun onSuccesGetUser(user: List<UserDataResponse>?)
    fun onFailedgetUser(msg: String)
    fun onLoading()
    fun onFinishedLoading()
}