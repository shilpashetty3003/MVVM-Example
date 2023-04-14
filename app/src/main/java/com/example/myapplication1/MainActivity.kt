package com.example.myapplication1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication1.mvvm_retrofit_room.db.UserDao
import com.example.myapplication1.mvvm_retrofit_room.db.UserDatabase
import com.example.myapplication1.mvvm_retrofit_room.network.RemoteSource
import com.example.myapplication1.mvvm_retrofit_room.network.UserAPI
import com.example.myapplication1.mvvm_retrofit_room.repository.UserRepo
import com.example.myapplication1.mvvm_retrofit_room.viewmodel.UserViewModel
import com.example.myapplication1.mvvm_retrofit_room.viewmodel.UserViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var userDao: UserDao
    lateinit var userAPI: UserAPI
    lateinit var userViewModel: UserViewModel
    lateinit var userRepo: UserRepo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userAPI=RemoteSource.getRemoteInstance().create(UserAPI::class.java)
        userDao=UserDatabase.getInstance(applicationContext).userDao()
        userRepo= UserRepo(userAPI,userDao,this)
        userViewModel= ViewModelProvider(this,UserViewModelFactory(userRepo)).get(UserViewModel::class.java)

        userViewModel.userDetails.observe(this, Observer {
            Log.d("TAG", "onCreateeeee: "+it)
        })
    }
}