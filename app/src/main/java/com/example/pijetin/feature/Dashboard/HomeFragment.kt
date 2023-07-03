package com.example.pijetin.feature.Dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pijetin.R
import com.example.pijetin.data.adapter.SpotlightListAdapter
import com.example.pijetin.data.model.DataSpotlight
import com.example.pijetin.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val adapterSpotlight: SpotlightListAdapter by lazy { SpotlightListAdapter () }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        adapterSpotlight.submitList(DataSpotlight.spotlightList)
        binding.rvSpotlight.adapter = adapterSpotlight
        binding.rvSpotlight.layoutManager = layoutManager

    }

}