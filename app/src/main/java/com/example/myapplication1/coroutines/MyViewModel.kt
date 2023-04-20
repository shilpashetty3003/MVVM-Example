package com.example.myapplication1.coroutines

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {

    init {
        viewModelScope.launch {


            while (true)
            {
                delay(500)
                Log.d("Kotlin", ": Hello")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()

        Log.d("Kotlin", "onCleared:  ")
    }
}