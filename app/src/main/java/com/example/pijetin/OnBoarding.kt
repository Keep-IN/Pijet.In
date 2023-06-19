package com.example.pijetin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.example.pijetin.databinding.ActivityOnBoardingBinding
import com.example.pijetin.feature.Login.Login
import com.example.pijetin.feature.signup.SignUp

class OnBoarding : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            startActivity(Intent(this,Login::class.java ))
        }

        binding.button.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
        }
    }
}