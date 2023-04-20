package com.example.myapplication1.coroutines.data.api

import com.example.myapplication1.coroutines.data.model.Mock_User
import com.example.myapplication1.coroutines.data.model.Mock_UserItem

interface APIInterface {

    suspend fun getUsers():List<Mock_UserItem>

    suspend fun getAllUsers():List<Mock_UserItem>

    suspend fun getError():List<Mock_UserItem>
}