package com.example.pijetin.feature.ForgetPass

interface Forgetcontract {
    fun onLoading()
    fun onFinishLoading()
    fun onError(code:Int, message: String)
    fun onSuccesEmail()
    fun onSuccsesForget()
    fun onErrorForget()
}