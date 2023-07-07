package com.example.pijetin.feature.Lengkapi

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import com.example.pijetin.R
import com.example.pijetin.databinding.ActivityLengkapDataDiriBinding
import com.example.pijetin.feature.Login.LoginPresenter


class LengkapDataDiri : AppCompatActivity() {
    private lateinit var binding: ActivityLengkapDataDiriBinding
    private lateinit var presenter: LengkapDataDiriPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val spannableString = SpannableString("Dengan ini saya menyatakan bahwa data yang saya isi adalah valid apa adanya. Jika saya melanggar\n" +
                "        peraturan yang ada, maka saya siap mengikuti prosedur hukum yang berlaku. *")
        val foregroundSpan = ForegroundColorSpan(Color.RED)
        spannableString.setSpan(foregroundSpan, 171, 172, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.tvKonfirmasiLengkapi.setText(spannableString)
    }
}