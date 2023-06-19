package com.example.pijetin.feature.ForgetPass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.example.pijetin.databinding.ActivityForgetPasswordBinding
import com.example.pijetin.feature.Login.Login

class ForgetPassword : AppCompatActivity(),Forgetcontract {
    private lateinit var binding: ActivityForgetPasswordBinding
    private lateinit var presenter : ForgetPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityForgetPasswordBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBackForget.setOnClickListener {
            startActivity(Intent(this,Login::class.java ))
        }

        presenter = ForgetPresenter(this).apply {
            onAttach(this@ForgetPassword)
        }

        binding.btnForget.isEnabled = false

        binding.tilEmailForget.editText?.doOnTextChanged { text, start, before, count ->
            validateinput()
            presenter.ValidetEmail(binding.tilEmailForget.editText?.text.toString())
        }
    }

    private fun validateinput(){
        binding.btnForget.isEnabled =  binding.tilEmailForget.editText?.text.toString().isNotBlank()
    }
    override fun onLoading() {
        TODO("Not yet implemented")
    }

    override fun onFinishLoading() {
        TODO("Not yet implemented")
    }

    override fun onError(code: Int, message: String) {
        when(code){
            1 -> binding.tilEmailForget.error = message
        }
    }

    override fun onSuccesEmail() {
        binding.tilEmailForget.error = ""
    }

    override fun onSuccsesForget() {
        TODO("Not yet implemented")
    }

    override fun onErrorForget() {
        TODO("Not yet implemented")
    }
}