package com.example.pijetin.feature.Dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.pijetin.R
import com.example.pijetin.databinding.ActivityNavBarContainerBinding
import com.example.pijetin.feature.Chat.ChatFragment
import com.example.pijetin.feature.History.HistoryFragment
import com.example.pijetin.feature.Settings.SettingsFragment

class NavbarContainer : AppCompatActivity() {
    private lateinit var binding: ActivityNavBarContainerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityNavBarContainerBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        replaceFragment(HomeFragment())
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

}