package com.example.pijetin.feature.Login

class LoginPresenter(
    private val view: LoginContract,
) {
    private var isEmailValid = false
    private var isPasswordValid = false

    fun onAttach(view: LoginContract){
        this.view

    }
    fun validateEmail(email: String): Boolean {
        isEmailValid = email.contains("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$".toRegex())
        if (isEmailValid) {
            view.onErrorEmpty(1)
        } else {
            view.onError(2, "Format email yang anda masukkan salah.")
        }
        return isEmailValid
    }
    fun validatePassword(password: String): Boolean {
        isPasswordValid = password.length > 8
        if (isPasswordValid) {
            view.onErrorEmpty(3)
        } else {
            view.onError(4, "Password minimal 8 huruf.")
        }
        return isPasswordValid
    }
}