package com.example.pijetin.feature.Chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pijetin.data.Api.UsersAPI
import com.example.pijetin.data.model.DataUserList
import com.example.pijetin.data.model.User
import com.example.pijetin.databinding.FragmentChatBinding
import com.example.pijetin.databinding.FragmentHomeBinding

class ChatFragment : Fragment(), ChatContract {
    private lateinit var binding: FragmentChatBinding
    private lateinit var presenter: ChatPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = ChatPresenter(this, UsersAPI()).apply {
            onAttach(this@ChatFragment)
        }
    }

    override fun onSucess() {

    }

    override fun onSuccesGetUserList(user: List<User>) {

    }

    override fun onErrorUserList(msg: String) {

    }
}