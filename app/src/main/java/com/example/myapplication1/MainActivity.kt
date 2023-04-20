package com.example.myapplication1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication1.mvvm_retrofit_room.db.UserDao
import com.example.myapplication1.mvvm_retrofit_room.db.UserDatabase
import com.example.myapplication1.mvvm_retrofit_room.network.RemoteSource
import com.example.myapplication1.mvvm_retrofit_room.network.UserAPI
import com.example.myapplication1.mvvm_retrofit_room.repository.UserRepo
import com.example.myapplication1.mvvm_retrofit_room.utils.Resource
import com.example.myapplication1.mvvm_retrofit_room.viewmodel.UserViewModel
import com.example.myapplication1.mvvm_retrofit_room.viewmodel.UserViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var userDao: UserDao
    lateinit var userAPI: UserAPI
    lateinit var userViewModel: UserViewModel
    lateinit var userRepo: UserRepo
    lateinit var progressBar: ProgressBar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = findViewById(R.id.pbShow)
        progressBar.visibility=View.GONE


        userRepo = (application as MyApplication).userRepo
        userViewModel =
            ViewModelProvider(this, UserViewModelFactory(userRepo)).get(UserViewModel::class.java)

        userViewModel.userDetails.observe(this, Observer {
            when (it) {
                is Resource.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {

                    progressBar.visibility = View.GONE
                    Log.d("TAG", "onCreateSUccess: "+it.data)

                    it.data.let {
                        Log.d("TAG", "onCreat76444e: ")
                    }
//                    it.data.let {dataaa->
//                        if(dataaa!=null){
//                            Log.d("TAG", "onCreate788888" +
//                                    ".: " + dataaa.toString())
//                        }
//                    }

                }
                is Resource.Failure -> {
                    progressBar.visibility = View.GONE

                }

            }
            Log.d("TAG", "onCreateeeee: " + it)
        })
    }
}