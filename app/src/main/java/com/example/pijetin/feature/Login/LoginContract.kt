package com.example.pijetin.feature.Login

import com.example.pijetin.data.Network.ResponseStatus
import com.example.pijetin.data.model.UserLoginResponse

interface LoginContract {
    fun onLoading()
    fun onFinishedLoading()
    fun onError(code: Int, message: String)
    fun onSuccesUsername()
    fun onSuccesPassword()
    fun onSuccesLogin(user: UserLoginResponse?)
    fun onErrorLogin(code: Int, message: String)
    fun onErrorEmpty(code: Int)
    fun onErrorFalse(code: Int, message: String)

}