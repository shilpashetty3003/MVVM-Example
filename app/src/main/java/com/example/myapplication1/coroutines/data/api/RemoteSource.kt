package com.example.myapplication1.coroutines.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RemoteSource {

    private const val BASE_URL="https://5e510330f2c0d300147c034c.mockapi.io/"

    private fun getInstance():Retrofit{
        return  Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    val userService:UserService= getInstance().create(UserService::class.java)

}