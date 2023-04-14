package com.example.myapplication1.mvvm_retrofit_room.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication1.mvvm_retrofit_room.repository.UserRepo

class UserViewModelFactory(var userRepo: UserRepo):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(userRepo) as T
    }
}