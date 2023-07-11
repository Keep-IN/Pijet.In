package com.example.pijetin.feature.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pijetin.databinding.ActivityConfirmProfileBinding
import com.example.pijetin.feature.Dashboard.NavbarContainer

class ConfirmProfile : AppCompatActivity() {
    private lateinit var  binding: ActivityConfirmProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityConfirmProfileBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnConfirmTolak.setOnClickListener {
            startActivity(Intent(this, NavbarContainer::class.java))
        }
    }
}