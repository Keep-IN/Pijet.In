package com.example.pijetin.feature

interface SignUpContract {
    fun onLoading()
    fun onFinishedLoading()
    fun onError(code: Int, message: String)
    fun onSuccesRegister()
    fun onSucces()
    fun onErrorSignup()
    fun onErrorSuccess(code: Int, message: String)
}