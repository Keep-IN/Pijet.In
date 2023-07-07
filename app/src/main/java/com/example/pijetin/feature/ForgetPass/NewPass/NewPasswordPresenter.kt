package com.example.pijetin.feature.ForgetPass.NewPass

class NewPasswordPresenter (
    private val view: NewPasswordContract
        ){
    private var isNewPasswordValid = false
    private var isNewPasswordUlangValid = false

    fun onAttach(view: NewPasswordContract){
        this.view
    }

    fun validateNewPassword(password: String): Boolean {
        //validasi format password lebih dari 7 karakter
        isNewPasswordValid = password.length > 7

        if (isNewPasswordValid) {
            view.onErrorEmpty(1)
        } else {
            view.onError(2,"Password minimal 8 karakter")
        }
        return isNewPasswordValid
    }

    fun validateNewPasswordUlang(password: String, repassword: String): Boolean {
        //validasi kesamaan password
        isNewPasswordUlangValid = repassword.equals(password)
        if (isNewPasswordUlangValid) {
            view.onErrorEmpty(3)
        } else {
            view.onError(4,"Password tidak sama")
        }
        return isNewPasswordUlangValid
    }

}