package com.example.pijetin.feature.signup

interface SignUpContract {
    fun onLoading()
    fun onFinishedLoading()
    fun onError(code: Int, message: String)
    fun onSuccesRegister()
    fun onSucces()
    fun onErrorSignup(message: String)
    fun onErrorSuccess(code: Int, message: String)

    fun onErrorAvailable(code : Int, message: String)
}