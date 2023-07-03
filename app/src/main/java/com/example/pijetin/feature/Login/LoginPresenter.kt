package com.example.pijetin.feature.Login

import android.provider.ContactsContract.CommonDataKinds.Email
import com.example.pijetin.data.Api.UsersAPI
import com.example.pijetin.data.Network.ResponseStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class LoginPresenter(
    private val view: LoginContract,
    private val api: UsersAPI,
    uiContext: CoroutineContext = Dispatchers.Main
) {
    private val supervisorJob: Job = SupervisorJob()
    private val scope = CoroutineScope(supervisorJob + uiContext)

    private var isEmailValid = false
    private var isPasswordValid = false
    private var isEmailCorrect = false
    private var isPasswordCorrect = false

    fun onAttach(view: LoginContract){
        this.view

    }
    fun validateEmail(email: String): Boolean {
        //validasi format email
        isEmailValid = email.contains("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$".toRegex())

        if (isEmailValid) {
            view.onErrorEmpty(1)
        }else {
            view.onError(2, "Format email yang anda masukkan salah.")
        }
        return isEmailValid
    }
    fun validatePassword(password: String): Boolean {
        //validasi email lebih dari 7 karakter
        isPasswordValid = password.length > 7


        if (isPasswordValid) {
            view.onErrorEmpty(3)
        }else {
            view.onError(4, "Password minimal 8 huruf.")
        }
        return isPasswordValid
    }

    fun loginUser(email: String, password: String){
        api.userLogin(email, password) {
            scope.launch {
                when(it){
                    is ResponseStatus.Success -> view.onSuccesLogin()
                    is ResponseStatus.Failed -> view.onErrorLogin(99, it.message)
                }
            }
        }
    }
}