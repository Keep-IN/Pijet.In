package com.example.pijetin.feature.Dashboard

import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedDispatcher
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.pijetin.R
import com.example.pijetin.data.Api.UsersAPI
import com.example.pijetin.data.adapter.RecentAdapter
import com.example.pijetin.data.adapter.SpotlightListAdapter
import com.example.pijetin.data.model.DataRiwayat
import com.example.pijetin.data.model.DataSpotlight
import com.example.pijetin.data.model.DataUser
import com.example.pijetin.data.model.UserDataResponse
import com.example.pijetin.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), HomeContract {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var presenter: HomePresnter
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

        presenter = HomePresnter(this, UsersAPI().apply {
            activity?.let { onAttach(it) }
        })
        presenter.getUserData()

        val layoutManagerHorizontal = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val layoutManager = LinearLayoutManager(activity)
        adapterSpotlight.submitList(DataSpotlight.spotlightList)
        binding.rvSpotlight.adapter = adapterSpotlight
        binding.rvSpotlight.layoutManager = layoutManagerHorizontal

        binding.tvUsername.text = DataUser.nama

        adapterRecent.submitList(DataRiwayat.riwayatList)
        binding.rvRecent.adapter = adapterRecent
        binding.rvRecent.layoutManager = layoutManager

        Glide
            .with(this)
            .load(DataUser.imageUrl)
            .into(binding.ivProfile)

    }

    override fun onSuccesGetUser(user: List<UserDataResponse>?) {
        user?.forEach {
            DataUser.nama = it.nama
            DataUser.email = it.email
            DataUser.imageUrl = it.image_url.toString()
        }
        onFinishedLoading()
    }

    override fun onFailedgetUser(msg: String) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
        OnBackPressedDispatcher().onBackPressed()
    }

    override fun onLoading() {
        binding.cvLoadingBg.visibility = View.VISIBLE
    }

    override fun onFinishedLoading() {
        binding.cvLoadingBg.visibility = View.GONE
    }

}