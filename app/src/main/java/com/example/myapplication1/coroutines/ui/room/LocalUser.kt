package com.example.myapplication1.coroutines.ui.room

import com.example.myapplication1.coroutines.data.model.Mock_UserItem

interface LocalUser {

    suspend fun insertUser(userList:List<Mock_UserItem>)

    suspend fun getAllUser():List<Mock_UserItem>
}