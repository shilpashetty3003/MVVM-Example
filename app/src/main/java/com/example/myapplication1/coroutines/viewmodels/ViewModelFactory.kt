package com.example.myapplication1.coroutines.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication1.coroutines.data.api.ApiInterfaceImpl
import com.example.myapplication1.coroutines.ui.room.LockUserImpl

class ViewModelFactory(var apiInterfaceImpl: ApiInterfaceImpl,var localUserImpl: LockUserImpl) :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SingleNetworkVIewModel::class.java)){
            return SingleNetworkVIewModel(apiInterfaceImpl,localUserImpl) as T
        }else
             return null as T
    }



}