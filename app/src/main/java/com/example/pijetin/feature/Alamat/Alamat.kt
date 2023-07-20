package com.example.pijetin.feature.Alamat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pijetin.R
import com.example.pijetin.data.adapter.AlamatAdapter
import com.example.pijetin.data.model.AlamatItemModel
import com.example.pijetin.data.model.DataAlamat
import com.example.pijetin.data.model.DataRiwayat
import com.example.pijetin.data.model.RiwayatItemModel
import com.example.pijetin.databinding.ActivityAlamatBinding
import com.example.pijetin.databinding.AlamatRadioGroupBinding
import com.example.pijetin.databinding.FragmentHistoryBinding
import com.example.pijetin.feature.Alamat.TambahAlamat.TambahAlamat
import com.example.pijetin.feature.Alamat.UbahAlamat.UbahAlamat
import com.example.pijetin.feature.History.Detail.DetilHistory

class Alamat : AppCompatActivity(){

    private lateinit var binding: ActivityAlamatBinding
    private val adapterAlamat: AlamatAdapter by lazy {AlamatAdapter()}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityAlamatBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(activity)
        adapterAlamat.submitList(DataAlamat.alamatList)
        binding.rvAlamat.adapter = adapterAlamat
        binding.rvAlamat.layoutManager = layoutManager
        adapterAlamat.setOnclickItem(rvClickListener)
    }

    private val rvClickListener: (AlamatItemModel) -> Unit =
        { item ->
            startActivity(Intent(activity, UbahAlamat::class.java))
        }
//    private var arrayList = ArrayList<AlamatItemModel>()
//    private var data = arrayOf("a","b","c")
//    private lateinit var binding: ActivityAlamatBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//
//        binding = ActivityAlamatBinding.inflate(layoutInflater)
//        super.onCreate(savedInstanceState)
//        setContentView(binding.root)
//
//        binding.ivBackAlamat.setOnClickListener {
//            onBackPressedDispatcher.onBackPressed()
//        }
//
//        val alamatAdapter = AlamatAdapter(this, getData())
//        binding.rvAlamat.layoutManager = LinearLayoutManager(this)
//        binding.rvAlamat.itemAnimator = DefaultItemAnimator()
//        binding.rvAlamat.addItemDecoration(
//            DividerItemDecoration(this,
//            LinearLayoutManager.VERTICAL
//            )
//        )
//        binding.rvAlamat.adapter = alamatAdapter
//    }
//
//    private fun getData(): ArrayList<AlamatItemModel> {
//        for(i in data.indices) {
//            arrayList.add(AlamatItemModel(data[i], false))
//        }
//        return arrayList
//    }
//    private lateinit var binding: ActivityAlamatBinding
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var adapter: AlamatAdapter
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        binding = ActivityAlamatBinding.inflate(layoutInflater)
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_alamat)
//
//        recyclerView = findViewById(R.id.rvAlamat)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        val items = listOf(
//            AlamatItemModel("Item 1"),
//            AlamatItemModel("Item 2"),
//            AlamatItemModel("Item 3")
//        )
//
//        adapter = AlamatAdapter(items)
//        recyclerView.adapter = adapter
//
//        setContentView(binding.root)
//
//        binding.ivBackAlamat.setOnClickListener {
//            onBackPressedDispatcher.onBackPressed()
//        }
//
//        binding.cvTambahLokasi.setOnClickListener {
//            startActivity(Intent(this, TambahAlamat::class.java))
//        }
//    }
//
//        binding.ivEditLokasiSaya.setOnClickListener {
//            startActivity(Intent(this, UbahAlamat::class.java))
//        }
//
//        binding.ivEditLokasiUtama.setOnClickListener {
//            startActivity(Intent(this, UbahAlamat::class.java))
//        }
//        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
//
//        val cardRadioButton1 = RadioButton(this)
//        cardRadioButton1.id = View.generateViewId()
//        cardRadioButton1.layoutParams = LinearLayout.LayoutParams(
//            LinearLayout.LayoutParams.MATCH_PARENT,
//            LinearLayout.LayoutParams.WRAP_CONTENT
//        )
//        cardRadioButton1.setBackgroundResource(R.drawable.bg_profil) // Optional: Set a background drawable
//        cardRadioButton1.setPadding(16, 16, 16, 16) // Optional: Set padding
//        cardRadioButton1.text = "Card 1" // Set the radio button text
//        cardRadioButton1.setOnClickListener {
//            // Handle click event for card 1
//        }
//        radioGroup.addView(cardRadioButton1)
//
//        // Create the second card radio button
//        val cardRadioButton2 = RadioButton(this)
//        cardRadioButton2.id = View.generateViewId()
//        cardRadioButton2.layoutParams = LinearLayout.LayoutParams(
//            LinearLayout.LayoutParams.MATCH_PARENT,
//            LinearLayout.LayoutParams.WRAP_CONTENT
//        )
//        cardRadioButton2.setBackgroundResource(R.drawable.bg_profil) // Optional: Set a background drawable
//        cardRadioButton2.setPadding(16, 16, 16, 16) // Optional: Set padding
//        cardRadioButton2.text = "Card 2" // Set the radio button text
//        cardRadioButton2.setOnClickListener {
//            // Handle click event for card 2
//        }
//        radioGroup.addView(cardRadioButton2)
//    }
}