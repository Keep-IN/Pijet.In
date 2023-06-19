package com.example.pijetin.feature.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.example.pijetin.OnBoarding
import com.example.pijetin.databinding.ActivityLoginBinding
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
            startActivity(Intent(this,OnBoarding::class.java ))
        }

        presenter = LoginPresenter(this).apply{
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
    }
    private fun validateInput(){
        binding.btnMasukLogin.isEnabled = binding.tilEmailLogin.editText?.text.toString().isNotBlank() &&
                binding.tilPwLogin.editText?.text.toString().isNotBlank()
    }

    override fun onLoading() {
        TODO("Not yet implemented")
    }

    override fun onFinishedLoading() {
        TODO("Not yet implemented")
    }

    override fun onError(code: Int, message: String) {
        when(code){
            2 -> binding.tilEmailLogin.error=message
            4 -> binding.tilPwLogin.error=message
        }
    }

    override fun onSuccesUsername() {
        TODO("Not yet implemented")
    }

    override fun onSuccesPassword() {
        TODO("Not yet implemented")
    }

    override fun onSuccesLogin() {
        TODO("Not yet implemented")
    }

    override fun onErrorLogin() {
        TODO("Not yet implemented")
    }

    override fun onErrorEmpty(code: Int) {
        when(code){
            1 -> binding.tilEmailLogin.error=""
            3 -> binding.tilPwLogin.error=""
        }

    }
}