package com.example.pijetin.feature.Alamat.TambahAlamat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pijetin.R
import com.example.pijetin.databinding.ActivityTambahAlamatBinding

class TambahAlamat : AppCompatActivity() {

    private lateinit var binding: ActivityTambahAlamatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTambahAlamatBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBackTambahAlamat.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}