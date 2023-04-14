package com.example.myapplication1.mvvm_retrofit_room.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RemoteSource {

    private val BASE_URL="https://jsonplaceholder.typicode.com/"

    fun getRemoteInstance():Retrofit{
        return  Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
}