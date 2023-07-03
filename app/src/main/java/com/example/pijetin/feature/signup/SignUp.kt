package com.example.pijetin.feature.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.pijetin.data.Api.UsersAPI
import com.example.pijetin.feature.OnBoarding.OnBoarding
import com.example.pijetin.databinding.ActivitySignUpBinding
import com.example.pijetin.feature.Login.Login

class SignUp : AppCompatActivity(), SignUpContract {
    private lateinit var  binding: ActivitySignUpBinding
    private lateinit var  presenter: SignUpPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter = SignUpPresenter(this, UsersAPI()).apply {
            onAtach(this@SignUp)
        }

        binding.imPiw1.setOnClickListener {
            startActivity(Intent(this, OnBoarding::class.java ))
        }

        binding.btnDaftar.setOnClickListener {
            startActivity(Intent(this, EmailVerification::class.java ))
        }
        binding.tPiw16.setOnClickListener {
            startActivity(Intent(this, Login::class.java ))
        }

        binding.tilEmail.editText?.doOnTextChanged { text, start, before, count ->
            validateInput()
            presenter.validateEmail(binding.tilEmail.editText?.text.toString(), )
        }
        binding.tilPassword.editText?.doOnTextChanged { text, start, before, count ->
            validateInput()
            presenter.validatePassword(binding.tilPassword.editText?.text.toString())
        }
        binding.tilTelephone.editText?.doOnTextChanged { text, start, before, count ->
            validateInput()
            presenter.validateTelephone(binding.tilTelephone.editText?.text.toString())
        }
        binding.tilUsername.editText?.doOnTextChanged { text, start, before, count ->
            validateInput()
        }
        binding.tilRePassword.editText?.doOnTextChanged { text, start, before, count ->
            validateInput()
            presenter.validateRepassword(binding.tilPassword.editText?.text.toString(),binding.tilRePassword.editText?.text.toString())
        }

        binding.btnDaftar.setOnClickListener {
            presenter.regisUser(binding.tilUsername.editText?.text.toString(),
                binding.tilTelephone.editText?.text.toString(),
                binding.tilEmail.editText?.text.toString(),
                binding.tilPassword.editText?.text.toString())
        }
    }

    override fun onErrorAvailable(code: Int, message: String) {
        when(code) {
            8 ->binding.tilEmail.error = message
        }
    }

    private fun validateInput(){
                binding.btnDaftar.isEnabled =
                binding.tilEmail.editText?.text.toString().isNotBlank() &&
                binding.tilTelephone.editText?.text.toString().isNotBlank() &&
                binding.tilPassword.editText?.text.toString().isNotBlank() &&
                binding.tilUsername.editText?.text.toString().isNotBlank() &&
                binding.tilRePassword.editText?.text.toString().isNotBlank()
    }
    override fun onLoading() {
        TODO("Not yet implemented")
    }

    override fun onFinishedLoading() {
        TODO("Not yet implemented")
    }

    override fun onError(code: Int, message: String) {
        when(code) {
            1 ->binding.tilEmail.error = message
            3 ->binding.tilPassword.error = message
            4 ->binding.tilTelephone.error = message
            5 ->binding.tilRePassword.error = message
        }
    }

    override fun onSuccesRegister() {
        startActivity(Intent(this, Login::class.java))
        Toast.makeText(this, "Akun berhasil terdaftar", Toast.LENGTH_SHORT).show()
    }

    override fun onSucces() {
        TODO("Not yet implemented")
    }

    override fun onErrorSignup(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    override fun onErrorSuccess(code: Int, message: String) {
        when(code) {
            2 ->binding.tilPassword.isErrorEnabled =false
            6 ->binding.tilTelephone.error =""
            1 ->binding.tilEmail.error = ""
            7 ->binding.tilRePassword.error = ""
        }
    }
}