package com.example.pijetin.feature.Dashboard

import com.example.pijetin.data.Api.UsersAPI
import com.example.pijetin.data.Network.ResponseStatus
import com.example.pijetin.feature.Login.LoginContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class HomePresnter(
    private val view: HomeContract,
    private val api: UsersAPI,
    uiContext: CoroutineContext = Dispatchers.Main
) {
    private val supervisorJob: Job = SupervisorJob()
    private val scope = CoroutineScope(supervisorJob + uiContext)

    fun onAttach(view: HomeContract){
        this.view
        getUserData()
    }

    fun getUserData(){
        api.getUserData {
            scope.launch {
                when(it){
                    is ResponseStatus.Success -> view.onSuccesGetUser(it.data?.toMutableList())
                    is ResponseStatus.Failed -> view.onFailedgetUser(it.message)
                }
            }
        }
    }
}