package com.example.myapplication1.mvvm.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RemoteDataSource {

    var BASE_URL="https://api.quotable.io/"

    fun getInstsnce(): Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
}