package com.example.pijetin.feature.signup

import com.example.pijetin.data.Api.UsersAPI
import com.example.pijetin.data.Network.ResponseStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SignUpPresenter (
    private val view: SignUpContract,
    private val api: UsersAPI,
    uiContext: CoroutineContext = Dispatchers.Main
        ) {
    private val supervisorJob: Job = SupervisorJob()
    private val scope = CoroutineScope(supervisorJob + uiContext)

    private var isEmailValid = false
    private var isPasswordValid = false
    private var isTelephoneValid = false
    private var isValidateRepassword = false
    private var isEmailAvailable = false

   fun onAtach(view: SignUpContract) {
       this.view
   }
    fun validateEmail(email: String): Boolean {
        val isEmailValid = email.contains("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$".toRegex())
        if (!isEmailValid){
            view.onError(1,"Format email tidak sesuai")
        } else {
            view.onErrorSuccess(1, "")
        }
        return isEmailValid
    }

    fun emailAvailable (email : String) : Boolean {
        isEmailAvailable = email == "keping@gmail.com"
        if (email == "keping@gmail.com") {
            view.onErrorAvailable(8, "Email Sudah Dipakai")
        }
        return isEmailAvailable
    }
    fun validatePassword (password: String): Boolean {
        val isPasswordValid = password.contains ("^(?=.*[a-zA-Z])(?=.*\\d).{8,}\$".toRegex())
        if (isPasswordValid) {
            view.onErrorSuccess(2, "")
        } else {
            view.onError(3, "Password minimal 8 huruf dan kata sandi harus terdiri dari angka dan huruf")
        }
        return isPasswordValid
    }
    fun validateTelephone (phone: String): Boolean {
        this.isTelephoneValid = phone.length in 9..13
            if (isTelephoneValid) {
                view.onErrorSuccess(6,"")
            } else {
                view.onError(4,"Nomor telephone yang anda masukkan salah")
            }
        return isTelephoneValid
    }
    fun validateRepassword (password : String, repassword: String): Boolean {
        isValidateRepassword = repassword.equals(password)
        if (isValidateRepassword) {
            view.onErrorSuccess(7,"")
        } else {
            view.onError(5,"Password tidak sama")
        }
        return isValidateRepassword
    }

    fun regisUser(nama: String, noTelp: String, email: String, password: String){
        api.addUser(nama, noTelp, email, password){
            scope.launch {
                when(it){
                    is ResponseStatus.Success -> view.onSuccesRegister(it.data)
                    is ResponseStatus.Failed -> view.onErrorSignup(it.message)
                }
            }
        }
    }

}