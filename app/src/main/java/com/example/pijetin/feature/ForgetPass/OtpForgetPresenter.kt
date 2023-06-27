package com.example.pijetin.feature.ForgetPass

class OtpForgetPresenter(
    private val view : OtpForgetContract
){
    private var isOtpForgetValid = false

    fun onAttach(view: OtpForgetContract){
        this.view
    }


}