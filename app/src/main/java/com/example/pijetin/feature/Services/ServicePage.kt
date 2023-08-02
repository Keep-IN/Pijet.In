package com.example.pijetin.feature.Services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.pijetin.feature.Address.MapAddress
import com.example.pijetin.R
import com.example.pijetin.databinding.ActivityServicePageBinding

class ServicePage : AppCompatActivity() {
    private  lateinit var binding: ActivityServicePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServicePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.flAdressService.setOnClickListener {
            startActivity(Intent(this, MapAddress::class.java))
        }

        //Menentukan isi dari detail halaman sesuai dengan kode yang dikirim dari halaman sebelumnya
        val serviceCode = intent.getStringExtra("service").toString()
        when(serviceCode){
            "1" -> {
                binding.tvServiceTittle.text = "Full body"
            }
            "2" -> {
                binding.tvServiceTittle.text = "Pijet Tradisional"
                binding.tvServiceSubtitle.text = "Pijat tradisional adalah praktik terapi fisik yang telah ada sejak zaman kuno dan masih populer hingga saat ini. Metode ini melibatkan penggunaan tekanan, gesekan, dan pijatan pada bagian tubuh tertentu untuk merangsang aliran energi dan memulihkan "
                binding.ivIlusstration.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_pijet_tradisional))
            }
            "3" -> {
                binding.tvServiceTittle.text = "Deep Tissue"
                binding.tvServiceSubtitle.text = "Pijat deep tissue adalah jenis pijat yang menggunakan tekanan kuat dan intensif untuk meredakan ketegangan otot dalam tubuh. Terapis menggunakan teknik-teknik khusus untuk merangsang jaringan otot yang dalam dan menghilangkan nodul-nodul otot yang menyebabkan"
                binding.ivIlusstration.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_deep_tissue))
            }
            "4" -> {
                binding.tvServiceTittle.text = "Hot Stone"
                binding.tvServiceSubtitle.text = "Pijat hot stone menggunakan batu-batu panas untuk memberikan pijatan dan efek relaksasi pada tubuh. Panas dari batu-batu membantu mengendurkan otot dan meningkatkan sirkulasi darah. Ini mengurangi ketegangan dan memberikan pengalaman yang menenangkan."
                binding.ivIlusstration.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_hot_stone))
            }
            "5" -> {
                binding.tvServiceTittle.text = "Thai Message"
                binding.tvServiceSubtitle.text = "Pijat Thai adalah praktik penyembuhan tradisional yang berasal dari Thailand. Terapis menggunakan tekanan dan peregangan tubuh untuk menghilangkan ketegangan, meningkatkan fleksibilitas, dan merangsang aliran energi. Pijat Thai dapat memberikan efek penyegaran dan rasa"
                binding.ivIlusstration.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_thai_message))
            }
            "6" -> {
                binding.tvServiceTittle.text = "Sweidh Message"
                binding.tvServiceSubtitle.text = "Pijat Swedia adalah jenis pijat yang populer di seluruh dunia. Selama sesi pijat Swedia, terapis menggunakan gerakan yang lembut dan terukur seperti menggosok, mengelus, dan menekan pada otot-otot tubuh. Teknik-teknik ini membantu meredakan ketegangan otot"
                binding.ivIlusstration.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_swedish_message))
            }
        }
    }
}