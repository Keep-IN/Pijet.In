package com.example.pijetin.feature.OnBoarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.example.pijetin.data.Api.UsersAPI
import com.example.pijetin.data.model.DataUserList
import com.example.pijetin.data.model.User
import com.example.pijetin.databinding.ActivityOnBoardingBinding
import com.example.pijetin.feature.Login.Login
import com.example.pijetin.feature.signup.SignUp

class OnBoarding : AppCompatActivity(), OnBoardContract {
    private lateinit var binding: ActivityOnBoardingBinding
    private lateinit var presnter: OnBoardPresnter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presnter = OnBoardPresnter(this, UsersAPI()).apply {
            onAttach(this@OnBoarding)
        }

        binding.button2.setOnClickListener {
            startActivity(Intent(this,Login::class.java ))
        }

        binding.button.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
        }
    }

    override fun onSucess() {
        TODO("Not yet implemented")
    }

    override fun onSuccesGetUserList(user: List<User>) {
        DataUserList.UserList = user as MutableList<User>
        Toast.makeText(this, "API Hit Success", Toast.LENGTH_SHORT).show()
    }

    override fun onErrorUserList(msg: String) {
        Handler(Looper.getMainLooper()).postDelayed({
            Toast.makeText(this@OnBoarding, msg, Toast.LENGTH_SHORT).show()
        }, 1000)
    }
}