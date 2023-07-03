package com.example.pijetin.feature.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.SystemClock
import com.example.pijetin.OnBoarding
import com.example.pijetin.R
import com.example.pijetin.databinding.ActivityEmailVerificationBinding
import com.example.pijetin.databinding.ActivitySignUpBinding
import io.bitfactory.pincodelayout.PinCodeActions

class EmailVerification : AppCompatActivity() {
    private lateinit var  binding: ActivityEmailVerificationBinding
    private lateinit var timer: CountDownTimer


    override fun onStart() {
        super.onStart()

        val totalTimeMillis: Long = 2 * 60 * 1000 + 30 * 1000// anjay

        timer = object : CountDownTimer(totalTimeMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                val minutes = seconds / 60
                val time = String.format("%02d:%02d", minutes, seconds % 60)
                binding.tPiwTimer.text = time
            }

            override fun onFinish() {
                binding.tPiwTimer.text = "00:00"
                // Timer finished, perform any required action here
            }
        }
        timer.start()
    }

    override fun onStop() {
        super.onStop()
        timer.cancel()
        }

    private val callback: PinCodeActions = object : PinCodeActions {
        override fun onPinEntered(pin: String) {
            onSucces()
        }

        override fun onPinCleared() {
            // Called when the pin is cleared/empty
        }

        override fun onPinFilled() {
            // Called when the pin is entered and the View looses focus
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEmailVerificationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnVerif.setOnClickListener {
            startActivity(Intent(this, ConfirmProfile::class.java ))
        }
    }

    fun onSucces(){
        startActivity(Intent(this, EmailVerification::class.java))
    }

}