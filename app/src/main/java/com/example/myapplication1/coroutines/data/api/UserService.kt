package com.example.myapplication1.coroutines.data.api

import com.example.myapplication1.coroutines.data.model.Mock_User
import com.example.myapplication1.coroutines.data.model.Mock_UserItem
import retrofit2.Response
import retrofit2.http.GET

interface UserService {

    @GET("users")
    suspend fun getUsers():List<Mock_UserItem>
    @GET("more-users")
    suspend fun getMoreUsers():List<Mock_UserItem>

    @GET("error")
    suspend fun getError():List<Mock_UserItem>
}



