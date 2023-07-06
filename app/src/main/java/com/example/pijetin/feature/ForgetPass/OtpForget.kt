package com.example.pijetin.feature.ForgetPass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.view.isNotEmpty
import com.example.pijetin.R
import com.example.pijetin.databinding.ActivityForgetPasswordBinding
import com.example.pijetin.databinding.ActivityOtpForgetBinding
import com.example.pijetin.feature.ForgetPass.NewPass.NewPassword
import com.example.pijetin.feature.Login.Login
import io.bitfactory.pincodelayout.PinCodeActions

class OtpForget : AppCompatActivity() {
    private lateinit var binding: ActivityOtpForgetBinding
    private lateinit var presenter : OtpForgetPresenter
    private lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityOtpForgetBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.pinOtpForget.setCallback(callback)

        binding.ivBackOtpForget.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.tvKirimUlangOtpForget.setOnClickListener{
            onStop()
            onStart()
        }

        binding.btnSelanjutnyaOtpForget.isEnabled = false

        binding.btnSelanjutnyaOtpForget.setOnClickListener{
            startActivity(Intent(this,NewPassword::class.java))
        }
    }

    private val callback: PinCodeActions = object : PinCodeActions {
        override fun onPinEntered(pin: String) {
            // Called when the pin is fully entered. Returns the pin
            onSuccesPin()
        }

        override fun onPinCleared() {
            // Called when the pin is cleared/empty
            binding.btnSelanjutnyaOtpForget.isEnabled = false
        }

        override fun onPinFilled() {
            // Called when the pin is entered and the View looses focus

        }
    }

    private fun onSuccesPin(){
        binding.btnSelanjutnyaOtpForget.isEnabled = binding.pinOtpForget.isNotEmpty()
    }

    override fun onStart() {
        super.onStart()

        val totalTimeMillis: Long = 2 * 60 * 1000 + 30 * 1000// 2 minutes 30 sec in milliseconds

        timer = object : CountDownTimer(totalTimeMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                val minutes = seconds / 60
                val time = String.format("%02d:%02d", minutes % 60, seconds % 60)
                binding.tvTimerOtpForget.text = time
            }

            override fun onFinish() {
                binding.tvTimerOtpForget.text = "00:00"
                // Timer finished, perform any required action here
            }
        }
        timer.start()
    }

    override fun onStop() {
        super.onStop()
        timer.cancel()
    }
}