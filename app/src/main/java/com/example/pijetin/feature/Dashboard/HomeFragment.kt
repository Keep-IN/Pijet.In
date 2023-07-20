package com.example.pijetin.feature.Dashboard

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.pijetin.feature.Services.ServicePage
import com.example.pijetin.data.adapter.RecentAdapter
import com.example.pijetin.data.adapter.SpotlightListAdapter
import com.example.pijetin.data.model.DataRiwayat
import com.example.pijetin.data.model.DataSpotlight
import com.example.pijetin.data.model.DataUser
import com.example.pijetin.databinding.FragmentHomeBinding
import com.example.pijetin.feature.Profil.Profil

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val adapterSpotlight: SpotlightListAdapter by lazy { SpotlightListAdapter () }
    private val adapterRecent: RecentAdapter by lazy {RecentAdapter()}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManagerHorizontal = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val layoutManager = LinearLayoutManager(activity)
        adapterSpotlight.submitList(DataSpotlight.spotlightList)
        binding.rvSpotlight.adapter = adapterSpotlight
        binding.rvSpotlight.layoutManager = layoutManagerHorizontal

        binding.tvUsername.text = DataUser.nama

        Glide
            .with(this)
            .load(DataUser.imageUrl)
            .into(binding.ivProfile)

        adapterRecent.submitList(DataRiwayat.riwayatList)
        binding.rvRecent.adapter = adapterRecent
        binding.rvRecent.layoutManager = layoutManager

        //Flow untuk tombol di setiap layanan
        with(binding){
            btnService01.setOnClickListener {
                startActivity(Intent(activity, ServicePage::class.java).apply {
                    putExtra("service", "1")
                })
            }
            btnService02.setOnClickListener {
                startActivity(Intent(activity, ServicePage::class.java).apply {
                    putExtra("service", "2")
                })
            }
            btnService03.setOnClickListener {
                startActivity(Intent(activity, ServicePage::class.java).apply {
                    putExtra("service", "3")
                })
            }
            btnService04.setOnClickListener {
                startActivity(Intent(activity, ServicePage::class.java).apply {
                    putExtra("service", "4")
                })
            }
            btnService05.setOnClickListener {
                startActivity(Intent(activity, ServicePage::class.java).apply {
                    putExtra("service", "5")
                })
            }
            btnService06.setOnClickListener {
                startActivity(Intent(activity, ServicePage::class.java).apply {
                    putExtra("service", "6")
                })
            }
            ivProfile.setOnClickListener {
                startActivity(Intent(activity, Profil::class.java))
            }
        }

    }

}