package com.example.pijetin.feature.Chat

import com.example.pijetin.data.model.User

interface ChatContract {
    fun onSucess()
    fun onSuccesGetUserList(user: List<User>)
    fun onErrorUserList(msg: String)
}