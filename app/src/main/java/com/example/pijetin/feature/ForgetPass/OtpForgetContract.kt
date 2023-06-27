package com.example.pijetin.feature.ForgetPass

interface OtpForgetContract {
    fun onErrorEmpty(code:Int, message: String)
    fun onSuccesOtp()
    fun onError(code: Int)
}