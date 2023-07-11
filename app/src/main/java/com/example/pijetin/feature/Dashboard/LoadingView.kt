package com.example.pijetin.feature.Dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.OnBackPressedDispatcher
import com.example.pijetin.R
import com.example.pijetin.data.Api.UsersAPI
import com.example.pijetin.data.model.DataUser
import com.example.pijetin.data.model.User
import com.example.pijetin.databinding.ActivityLoadingViewBinding
import com.example.pijetin.feature.OnBoarding.OnBoarding

class LoadingView : AppCompatActivity(), HomeContract {
    private lateinit var binding: ActivityLoadingViewBinding
    private lateinit var presenter: HomePresnter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoadingViewBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter = HomePresnter(this, UsersAPI()).apply {
            onAttach(this@LoadingView)
        }

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, NavbarContainer::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

    override fun onSuccesGetUser(user: List<User>?) {
        user?.forEach {
            DataUser.nama = it.nama
            DataUser.email = it.email
            DataUser.imageUrl = it.image_url.toString()
        }
    }

    override fun onFailedgetUser(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        OnBackPressedDispatcher().onBackPressed()
    }

    override fun onLoading() {
        TODO("Not yet implemented")
    }

    override fun onFinishedLoading() {
        TODO("Not yet implemented")
    }
}