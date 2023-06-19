package com.example.pijetin.feature.signup

class SignUpPresenter (
    private val view: SignUpContract
        ) {
    private var isEmailValid = false
    private var isPasswordValid = false
    private var isTelephoneValid = false
    private var isValidateRepassword = false

   fun onAtach(view: SignUpContract) {
       this.view
   }
    fun validateEmail(email: String): Boolean {
        val isEmailValid = email.contains("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$".toRegex())
        if (!isEmailValid){
            view?.onError(1,"Format email tidak sesuai")
        } else {
            view?.onErrorSuccess(1, "")
        }
        return isEmailValid
    }
    fun validatePassword (password: String): Boolean {
         isPasswordValid = password.length > 8
        if (isPasswordValid) {
            view.onErrorSuccess(2, "")
        } else {
            view.onError(3, "Password minimal 8 huruf")
        }
        return isPasswordValid
    }
    fun validateTelephone (phone: String): Boolean {
        isTelephoneValid = phone.length > 9  && phone.length < 14
            if (isTelephoneValid) {
                view.onErrorSuccess(6,"")
            } else {
                view.onError(4,"Nomor telephone yang anda masukkan salah")
            }
        return isTelephoneValid
    }
    fun validateRepassword ( password: String,repassword: String): Boolean {
        isValidateRepassword = repassword.equals(password)
        if (isValidateRepassword) {
            view.onSucces()
        } else {
            view.onError(5,"Password tidak sama")
        }
        return isValidateRepassword
    }

}