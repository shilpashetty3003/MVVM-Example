package com.example.myapplication1.Flows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.myapplication1.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class FlowsExample : AppCompatActivity() {

    private val TAG = "KotlinFlow"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flows_example)
        producer()
        //consumer()
        lifecycleScope.launch {
            producer()
                .collect() {
                    Log.d(TAG, "Collector1: " + it)
                }
        }
        lifecycleScope.launch {
            var result = producer()
            delay(2000)
            result.collect() {
                Log.d(TAG, "Collector2: " + it)
            }
        }
    }

    fun producer(): Flow<Int> {

        var mutableSharedFlow = MutableSharedFlow<Int>(replay = 2)
        var list = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)
        lifecycleScope.launch {
            list.forEach {
                mutableSharedFlow.emit(it)
                delay(1000)
            }
        }
        return mutableSharedFlow
    }

    fun consumer() {
        GlobalScope.launch {

            var data = producer()

            data.collect() {
                Log.d("TAG", "consumer1: " + it)
            }

        }
        GlobalScope.launch {
            var data2 = producer()
            data2.collect() {
                Log.d("TAG", "consumer2: " + it)
            }
        }
    }


}