package com.example.pijetin.feature.OnBoarding

import com.example.pijetin.data.model.User

interface OnBoardContract {
    fun onSucess()
    fun onSuccesGetUserList(user: List<User>)
    fun onErrorUserList(msg: String)
}