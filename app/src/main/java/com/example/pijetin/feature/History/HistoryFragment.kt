package com.example.pijetin.feature.History

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.pijetin.R
import com.example.pijetin.data.adapter.HistoryListAdapter
import com.example.pijetin.data.model.DataRiwayat
import com.example.pijetin.data.model.RiwayatItemModel
import com.example.pijetin.databinding.FragmentHistoryBinding
import com.example.pijetin.feature.History.Detail.DetilHistory
import kotlin.math.round

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private val adapterHistory: HistoryListAdapter by lazy { HistoryListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(activity)
        binding.rvHistory.adapter = adapterHistory
        binding.rvHistory.layoutManager = layoutManager
        adapterHistory.setOnclickItem(rvClickListener)


        binding.cvSemuaHistory.setOnClickListener() {
            adapterHistory.submitList(DataRiwayat.riwayatList)
            binding.apply {
                cvSemuaHistory.setCardBackgroundColor(Color.parseColor("#56AB91"))
                tvSemuaHistory.setTextColor(Color.parseColor("#FFFFFF"))
                cvDijadwalkanHistory.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
                tvDijadwalkanHistory.setTextColor(Color.parseColor("#000000"))
                cvDibatalkanHistory.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
                tvDibatalkanHistory.setTextColor(Color.parseColor("#000000"))
                cvSelesaiHistory.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
                tvSelesaiHistory.setTextColor(Color.parseColor("#000000"))
            }
        }

        binding.cvDijadwalkanHistory.setOnClickListener() {
            val filteredHistory = DataRiwayat.riwayatList.filter {
                it.status.contains("Dijadwalkan")
            }
            adapterHistory.submitList(filteredHistory)
            binding.apply {
                cvSemuaHistory.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
                tvSemuaHistory.setTextColor(Color.parseColor("#000000"))
                cvDijadwalkanHistory.setCardBackgroundColor(Color.parseColor("#56AB91"))
                tvDijadwalkanHistory.setTextColor(Color.parseColor("#FFFFFF"))
                cvDibatalkanHistory.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
                tvDibatalkanHistory.setTextColor(Color.parseColor("#000000"))
                cvSelesaiHistory.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
                tvSelesaiHistory.setTextColor(Color.parseColor("#000000"))
            }
        }

        binding.cvDibatalkanHistory.setOnClickListener() {
            val filteredHistory = DataRiwayat.riwayatList.filter {
                it.status.contains("Dibatalkan")
            }
            adapterHistory.submitList(filteredHistory)
            binding.apply {
                cvSemuaHistory.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
                tvSemuaHistory.setTextColor(Color.parseColor("#000000"))
                cvDijadwalkanHistory.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
                tvDijadwalkanHistory.setTextColor(Color.parseColor("#000000"))
                cvDibatalkanHistory.setCardBackgroundColor(Color.parseColor("#56AB91"))
                tvDibatalkanHistory.setTextColor(Color.parseColor("#FFFFFF"))
                cvSelesaiHistory.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
                tvSelesaiHistory.setTextColor(Color.parseColor("#000000"))
            }
        }

        binding.cvSelesaiHistory.setOnClickListener() {
            val filteredHistory = DataRiwayat.riwayatList.filter {
                it.status.contains("Selesai")
            }
            adapterHistory.submitList(filteredHistory)
            binding.apply {
                cvSemuaHistory.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
                tvSemuaHistory.setTextColor(Color.parseColor("#000000"))
                cvDijadwalkanHistory.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
                tvDijadwalkanHistory.setTextColor(Color.parseColor("#000000"))
                cvDibatalkanHistory.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
                tvDibatalkanHistory.setTextColor(Color.parseColor("#000000"))
                cvSelesaiHistory.setCardBackgroundColor(Color.parseColor("#56AB91"))
                tvSelesaiHistory.setTextColor(Color.parseColor("#FFFFFF"))
            }
        }
    }
    private val rvClickListener: (RiwayatItemModel) -> Unit =
        { item ->
            startActivity(Intent(activity, DetilHistory::class.java))
    }
}