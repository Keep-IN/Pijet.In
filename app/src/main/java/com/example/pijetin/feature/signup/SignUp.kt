package com.example.pijetin.feature.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.example.pijetin.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity(), SignUpContract {
    private lateinit var  binding: ActivitySignUpBinding
    private lateinit var  presenter: SignUpPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tilEmail.editText?.doOnTextChanged { text, start, before, count ->
            validateInput()
            presenter.validateEmail(binding.tilEmail.editText?.text.toString())
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
        }
        presenter = SignUpPresenter(this).apply {
            onAtach(this@SignUp)
        }
    }
    private fun validateInput(){
        binding.btnDaftar.isEnabled = binding.tilEmail.editText?.text.toString().isNotBlank() &&
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
        }
    }

    override fun onSuccesRegister() {
        TODO("Not yet implemented")
    }

    override fun onSucces() {
        TODO("Not yet implemented")
    }

    override fun onErrorSignup() {
        TODO("Not yet implemented")
    }

    override fun onErrorSuccess(code: Int, message: String) {
        when(code) {
            2 ->binding.tilPassword.isErrorEnabled =false
            6 ->binding.tilTelephone.error =""
            1 ->binding.tilEmail.error = ""
        }
    }
}