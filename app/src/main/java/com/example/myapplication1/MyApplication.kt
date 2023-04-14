package com.example.myapplication1

import android.app.Application
import com.example.myapplication1.mvvm_retrofit_room.db.UserDatabase
import com.example.myapplication1.mvvm_retrofit_room.network.RemoteSource
import com.example.myapplication1.mvvm_retrofit_room.network.UserAPI
import com.example.myapplication1.mvvm_retrofit_room.repository.UserRepo

class MyApplication : Application() {

    lateinit var userRepo: UserRepo
    override fun onCreate() {
        super.onCreate()
        initializer()
    }

    fun initializer(){
        var userAPI= RemoteSource.getRemoteInstance().create(UserAPI::class.java)
        var userDao= UserDatabase.getInstance(applicationContext).userDao()
        userRepo=UserRepo(userAPI,userDao,applicationContext)
    }


}