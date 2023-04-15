package com.example.myapplication1.mvvm_retrofit_room.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication1.mvvm_retrofit_room.model.Users
import com.example.myapplication1.mvvm_retrofit_room.model.UsersItem
import com.example.myapplication1.mvvm_retrofit_room.repository.UserRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(var userRepo: UserRepo) : ViewModel() {

    //var userDetails_ = MutableLiveData<List<UsersItem>>()

    val userDetails: LiveData<List<UsersItem>>
        get() = userRepo.apiResult

    fun insertUser(userList: List<UsersItem>) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepo.insertData(userList)
        }
    }

    init {
        viewModelScope.launch(Dispatchers.IO){
            userRepo.getUserDetails()
        }
    }


}