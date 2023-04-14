package com.example.myapplication1.mvvm_retrofit_room.network

import com.example.myapplication1.mvvm_retrofit_room.model.Users
import retrofit2.Response
import retrofit2.http.GET


interface UserAPI {
    @GET("/users")
    suspend fun getUsers():Response<Users>
}