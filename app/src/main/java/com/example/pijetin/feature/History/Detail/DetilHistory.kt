package com.example.pijetin.feature.History.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.pijetin.R
import com.example.pijetin.databinding.ActivityDetilHistoryBinding
import com.example.pijetin.databinding.ActivityOtpForgetBinding
import com.example.pijetin.feature.ForgetPass.OtpForgetPresenter

class DetilHistory : AppCompatActivity() {

    private lateinit var binding: ActivityDetilHistoryBinding
    private lateinit var presenter: DetilPresenter
    private lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetilHistoryBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBackDetail.setOnClickListener(){
            onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun onStart() {
        super.onStart()

        val totalTimeMillis: Long = 4 * 60 * 60 * 1000// 4 hours

        timer = object : CountDownTimer(totalTimeMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                val minutes = seconds / 60
                val hour = minutes / 60
                val time = String.format("%02d:%02d:%02d", hour, minutes % 60, seconds % 60)
                binding.tvTimerDetil.text = time
            }

            override fun onFinish() {
                binding.tvTimerDetil.text = "-- -- --"
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