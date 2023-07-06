package com.example.pijetin.feature.ForgetPass.NewPass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.example.pijetin.R
import com.example.pijetin.data.Api.UsersAPI
import com.example.pijetin.databinding.ActivityNewPasswordBinding
import com.example.pijetin.feature.ForgetPass.ForgetPresenter
import com.example.pijetin.feature.Login.Login

class NewPassword : AppCompatActivity(), NewPasswordContract

{
    private lateinit var binding: ActivityNewPasswordBinding
    private lateinit var presenter: NewPasswordPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityNewPasswordBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter = NewPasswordPresenter(this).apply {
            onAttach(this@NewPassword)
        }

        binding.btnSimpanPwBaru.isEnabled = false

        binding.ivBackNewPw.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }

        binding.tilPwBaru.editText?.doOnTextChanged{ text, start, before, count ->
            validateInput()
            presenter.validateNewPassword(binding.tilPwBaru.editText?.text.toString())
        }

        binding.tilPwBaruUlang.editText?.doOnTextChanged{ text, start, before, count ->
            validateInput()
            presenter.validateNewPasswordUlang(binding.tilPwBaru.editText?.text.toString(),
            binding.tilPwBaruUlang.editText?.text.toString())
        }

        binding.btnSimpanPwBaru.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }
    }

    private fun validateInput() {
        binding.btnSimpanPwBaru.isEnabled = binding.tilPwBaru.editText?.text.toString().isNotBlank() &&
                binding.tilPwBaruUlang.editText?.text.toString().isNotBlank()

    }

    override fun onError(code: Int, message: String){
        when(code){
            2 -> binding.tilPwBaru.error=message
            4 -> binding.tilPwBaruUlang.error=message
        }
    }

    override fun onErrorEmpty(code: Int){
        when(code){
            1 -> binding.tilPwBaru.isErrorEnabled = false
            3 -> binding.tilPwBaruUlang.isErrorEnabled = false
        }
    }
}