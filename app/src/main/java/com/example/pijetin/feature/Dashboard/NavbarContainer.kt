package com.example.pijetin.feature.Dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedDispatcher
import androidx.fragment.app.Fragment
import com.example.pijetin.R
import com.example.pijetin.data.Api.UsersAPI
import com.example.pijetin.data.model.DataUser
import com.example.pijetin.data.model.UserDataResponse
import com.example.pijetin.databinding.ActivityNavBarContainerBinding
import com.example.pijetin.feature.Chat.ChatFragment
import com.example.pijetin.feature.History.HistoryFragment
import com.example.pijetin.feature.Settings.SettingsFragment

class NavbarContainer : AppCompatActivity(), HomeContract {
    private lateinit var binding: ActivityNavBarContainerBinding
    private lateinit var presenter: HomePresnter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityNavBarContainerBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        presenter = HomePresnter(this, UsersAPI()).apply {
            onAttach(this@NavbarContainer)
        }

        binding.bottomNavigationView.selectedItemId = R.id.nav_home
        binding.bottomNavigationView.itemIconTintList = null
        binding.bottomNavigationView.isItemActiveIndicatorEnabled = false
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> replaceFragment(HomeFragment())
                R.id.nav_chat -> replaceFragment(ChatFragment())
                R.id.nav_history -> replaceFragment(HistoryFragment())
                R.id.nav_profile -> replaceFragment(SettingsFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.apply {
            replace(R.id.fragContainer, fragment)
            commit()
        }
    }

    override fun onSuccesGetUser(user: List<UserDataResponse>?) {
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