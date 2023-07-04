package com.example.pijetin.feature.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import com.example.pijetin.data.Api.UsersAPI
import com.example.pijetin.data.Network.ResponseStatus
import com.example.pijetin.data.model.DataUser
import com.example.pijetin.data.model.UserLoginResponse
import com.example.pijetin.databinding.ActivityLoginBinding
import com.example.pijetin.feature.Dashboard.NavBarContainer
import com.example.pijetin.feature.ForgetPass.ForgetPassword

class Login : AppCompatActivity(), LoginContract {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvLupaPwLogin.setOnClickListener {
            startActivity(Intent(this,ForgetPassword::class.java ))
        }

        binding.ivBackLogin.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btnMasukLogin.isEnabled = false

        presenter = LoginPresenter(this, UsersAPI()).apply{
            onAttach(this@Login)
        }

        binding.tilEmailLogin.editText?.doOnTextChanged { text, start, before, count ->
            validateInput()
            presenter.validateEmail(binding.tilEmailLogin.editText?.text.toString())
        }

        binding.tilPwLogin.editText?.doOnTextChanged { text, start, before, count ->
            validateInput()
            presenter.validatePassword((binding.tilPwLogin.editText?.text.toString()))
        }

        binding.btnMasukLogin.setOnClickListener{
            // cek eror button masuk
            onLoading()
            presenter.loginUser(binding.tilEmailLogin.editText?.text.toString(),
                binding.tilPwLogin.editText?.text.toString())
        }
    }
    private fun validateInput(){
        binding.btnMasukLogin.isEnabled = binding.tilEmailLogin.editText?.text.toString().isNotBlank() &&
                binding.tilPwLogin.editText?.text.toString().isNotBlank()
    }

    override fun onLoading() {
        binding.bgLoading.visibility = View.VISIBLE
        binding.pbLoading.visibility = View.VISIBLE
    }

    override fun onFinishedLoading() {
        binding.bgLoading.visibility = View.GONE
        binding.pbLoading.visibility = View.GONE
    }

    override fun onError(code: Int, message: String) {
        when(code){
            // nampilin error message
            2 -> binding.tilEmailLogin.error = message
            4 -> binding.tilPwLogin.error = message
        }
    }

    override fun onSuccesUsername() {
        TODO("Not yet implemented")
    }

    override fun onSuccesPassword() {
        TODO("Not yet implemented")
    }

    override fun onSuccesLogin(user: UserLoginResponse?) {
        //fungsi pindah login ke dashboard + allert
        if (user != null) {
            DataUser.nama = user.nama
            DataUser.email = user.email
        }
        startActivity(Intent(this, NavBarContainer::class.java))
        Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
        onFinishedLoading()
    }

    override fun onErrorLogin(code: Int, message: String) {
        Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show()
        onFinishedLoading()
    }

    override fun onErrorFalse(code: Int, message: String) {
        //nampilin error message
        when(code){
            5 -> binding.tilEmailLogin.error=message
            6 -> binding.tilPwLogin.error=message
        }
    }

    override fun onErrorEmpty(code: Int) {
        when(code){
            //ngilangin error message
            1 -> binding.tilEmailLogin.error=""
            3 -> binding.tilPwLogin.error=""
        }

    }
}