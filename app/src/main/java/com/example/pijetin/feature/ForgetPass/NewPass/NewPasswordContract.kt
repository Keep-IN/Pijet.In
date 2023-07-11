package com.example.pijetin.feature.ForgetPass.NewPass

interface NewPasswordContract {
    fun onErrorEmpty(code: Int)
    fun onError(code: Int, message: String)
}