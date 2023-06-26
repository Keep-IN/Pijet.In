package com.example.pijetin.feature.Login

import android.inputmethodservice.AbstractInputMethodService

interface LoginContract {
    fun onLoading()
    fun onFinishedLoading()
    fun onError(code: Int, message: String)
    fun onSuccesUsername()
    fun onSuccesPassword()
    fun onSuccesLogin()
    fun onErrorLogin(code: Int, message: String)
    fun onErrorEmpty(code: Int)
    fun onErrorFalse(code: Int, message: String)

}