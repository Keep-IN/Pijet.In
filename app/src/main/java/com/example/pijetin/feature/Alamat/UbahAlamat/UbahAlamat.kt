package com.example.pijetin.feature.Alamat.UbahAlamat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pijetin.R
import com.example.pijetin.databinding.ActivityAlamatBinding
import com.example.pijetin.databinding.ActivityUbahAlamatBinding

class UbahAlamat : AppCompatActivity() {

    private lateinit var binding: ActivityUbahAlamatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUbahAlamatBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBackUbahAlamat.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}