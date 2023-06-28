package com.example.pijetin.feature.History

import android.content.Intent
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
        adapterHistory.submitList(DataRiwayat.riwayatList)
        binding.rvHistory.adapter = adapterHistory
        binding.rvHistory.layoutManager = layoutManager
        adapterHistory.setOnclickItem(rvClickListener)
    }

    private val rvClickListener: (RiwayatItemModel) -> Unit = {

    }
}