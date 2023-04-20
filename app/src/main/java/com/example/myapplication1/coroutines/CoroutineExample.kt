package com.example.myapplication1.coroutines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.myapplication1.R
import kotlinx.coroutines.*

class CoroutineExample : AppCompatActivity() {
    lateinit var myViewModel: MyViewModel
    var TAG = "Kotlin"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_example)
//        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)


//        lifecycleScope.launch {
//            delay(2000)
//            var intent=Intent(this@CoroutineExample,NextActivity::class.java)
//            startActivity(intent)
//            finish()
//        }

        GlobalScope.launch {
            execute()
        }

    }

    suspend fun execute() {



        var job1=GlobalScope.launch {
            for (i in 1..10000){
                Log.d(TAG, "execute: ")
            }
        }
        delay(5000)
        job1.cancel()




    }

    suspend fun execute1(){

        for(i in 1..100000000000000){

        }
    }
}