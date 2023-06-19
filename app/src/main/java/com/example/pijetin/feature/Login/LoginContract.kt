package com.example.pijetin.feature.Login

interface LoginContract {
    fun onLoading()
    fun onFinishedLoading()
    fun onError(code: Int, message: String)
    fun onSuccesUsername()
    fun onSuccesPassword()
    fun onSuccesLogin()
    fun onErrorLogin()
    fun onErrorEmpty(code: Int)
}