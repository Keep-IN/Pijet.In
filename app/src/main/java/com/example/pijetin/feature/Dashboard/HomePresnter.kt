package com.example.pijetin.feature.Dashboard

import com.example.pijetin.data.Api.OrdersAPI
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
    private val apiOrder: OrdersAPI,
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

    fun getOrderData(){
        apiOrder.getOrder {
            scope.launch {
                when(it){
                    is ResponseStatus.Success -> view.onSuccesGetOrder(it.data.toMutableList())
                    is ResponseStatus.Failed -> view.onFailedGetOrder(it.message)
                }
            }
        }
    }
}