package com.example.pijetin.feature.ForgetPass

class ForgetPresenter (
    private val view : Forgetcontract
        ){
    private var isEmailValid = false
    fun onAttach(view :Forgetcontract){
        this.view
    }

    fun ValidetEmail(email : String):Boolean{
        isEmailValid = email.contains("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$".toRegex())
        if (isEmailValid){
            view.onSuccesEmail()
        }else{
            view.onError(1, "Format email yang anda masukan tidak sesuai")
        }
        return isEmailValid
    }
}