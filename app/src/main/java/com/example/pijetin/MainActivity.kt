package com.example.pijetin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.example.pijetin.data.model.DataToken
import com.example.pijetin.databinding.ActivityMainBinding
import com.example.pijetin.feature.Dashboard.LoadingView
import com.example.pijetin.feature.OnBoarding.OnBoarding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler(Looper.getMainLooper()).postDelayed({
            if(DataToken.token == ""){
                startActivity(Intent(this, OnBoarding::class.java))
                finish()
            } else {
                startActivity(Intent(this, LoadingView::class.java))
                finish()
            }

        }, 3000)
    }
}