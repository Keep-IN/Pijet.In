package com.example.pijetin.feature.Profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.pijetin.R
import com.example.pijetin.databinding.ActivityOtpForgetBinding
import com.example.pijetin.databinding.ActivityProfilBinding
import com.example.pijetin.feature.ForgetPass.OtpForgetPresenter
import com.example.pijetin.feature.Lengkapi.LengkapDataDiri

class Profil : AppCompatActivity() {
    private lateinit var binding: ActivityProfilBinding
    private lateinit var presenter : ProfilPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProfilBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.cvLengkapi.setOnClickListener{
            startActivity(Intent(this, LengkapDataDiri::class.java))
        }
    }
}