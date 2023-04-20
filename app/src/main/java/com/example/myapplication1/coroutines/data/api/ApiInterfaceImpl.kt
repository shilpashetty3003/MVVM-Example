package com.example.myapplication1.coroutines.data.api

import com.example.myapplication1.coroutines.data.model.Mock_UserItem

class ApiInterfaceImpl(var userService: UserService):APIInterface {
    override suspend fun getUsers()=userService.getUsers()

    override suspend fun getAllUsers()=userService.getMoreUsers()


    override suspend fun getError()=userService.getError()
}