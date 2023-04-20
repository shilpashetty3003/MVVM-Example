package com.example.myapplication1

import android.app.Application
import android.util.Log
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.example.myapplication1.mvvm_retrofit_room.db.UserDao
import com.example.myapplication1.mvvm_retrofit_room.db.UserDatabase
import com.example.myapplication1.mvvm_retrofit_room.network.RemoteSource
import com.example.myapplication1.mvvm_retrofit_room.network.UserAPI
import com.example.myapplication1.mvvm_retrofit_room.repository.UserRepo
import java.util.concurrent.TimeUnit

class MyApplication : Application() {

    lateinit var userRepo: UserRepo
    lateinit var userDao: UserDao
    override fun onCreate() {
        super.onCreate()
        initializer()
//        setUpWorkManager()
    }

    fun setUpWorkManager(){
        var constraint=Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        var workManager=PeriodicWorkRequest.Builder(QuoteWorkManager::class.java,15,TimeUnit.MINUTES).setConstraints(constraint).build()
        WorkManager.getInstance(this).enqueue(workManager)

    }
    fun initializer(){
        var userAPI= RemoteSource.getRemoteInstance().create(UserAPI::class.java)
         userDao= UserDatabase.getInstance(applicationContext).userDao()
        userRepo=UserRepo(userAPI,userDao,applicationContext)
    }

}