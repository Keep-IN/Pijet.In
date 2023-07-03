package com.example.pijetin.feature.OnBoarding

import com.example.pijetin.data.Api.UsersAPI
import com.example.pijetin.data.Network.ResponseStatus
import com.example.pijetin.feature.Chat.ChatContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class OnBoardPresnter(
    private val view: OnBoardContract,
    private val api: UsersAPI,
    uiContext: CoroutineContext = Dispatchers.Main
) {
    private val supervisorJob: Job = SupervisorJob()
    private val scope = CoroutineScope(supervisorJob + uiContext)

    fun onAttach(view: OnBoardContract) {
        this.view
        getUser()
    }

    fun getUser(){
        api.getUser {
            scope.launch {
                when (it) {
                    is ResponseStatus.Success -> view.onSuccesGetUserList(it.data.toMutableList())
                    is ResponseStatus.Failed -> view.onErrorUserList(it.message)
                    else -> {}
                }
            }
        }
    }
}