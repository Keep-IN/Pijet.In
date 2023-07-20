package com.example.pijetin.feature.Profil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pijetin.R
import com.example.pijetin.databinding.ActivityProfilBinding
import com.example.pijetin.feature.Alamat.Alamat
import com.example.pijetin.feature.Lengkapi.LengkapDataDiri

class Profil : AppCompatActivity() {

    private lateinit var binding: ActivityProfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProfilBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBackProfil.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.cvLengkapi.setOnClickListener {
            startActivity(Intent(this, LengkapDataDiri::class.java))
        }

        binding.cvAlamatProfil.setOnClickListener {
            startActivity(Intent(this, Alamat::class.java))
        }
    }
}