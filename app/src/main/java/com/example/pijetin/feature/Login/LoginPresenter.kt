package com.example.pijetin.feature.Login

import android.provider.ContactsContract.CommonDataKinds.Email

class LoginPresenter(
    private val view: LoginContract,
) {
    private var isEmailValid = false
    private var isPasswordValid = false
    private var isEmailCorrect = false
    private var isPasswordCorrect = false

    fun onAttach(view: LoginContract){
        this.view

    }
    fun validateEmail(email: String): Boolean {
        isEmailValid = email.contains("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$".toRegex())

        if (isEmailValid) {
            view.onErrorEmpty(1)
        }else {
            view.onError(2, "Format email yang anda masukkan salah.")
        }
        return isEmailValid
    }
    fun validatePassword(password: String): Boolean {
        isPasswordValid = password.length > 7


        if (isPasswordValid) {
            view.onErrorEmpty(3)
        }else {
            view.onError(4, "Password minimal 8 huruf.")
        }
        return isPasswordValid
    }
    fun validateCredential(email: String, password: String){
        isEmailCorrect= email == "keping@gmail.com"
        isPasswordCorrect = password == "yantogoblok"
        if (email != "keping@gmail.com"){
            view.onErrorFalse(5, "Email anda tidak terdaftar!")
        }
        if(password != "yantogoblok") {
            view.onErrorFalse(6, "Password salah!")
        }
    }
}