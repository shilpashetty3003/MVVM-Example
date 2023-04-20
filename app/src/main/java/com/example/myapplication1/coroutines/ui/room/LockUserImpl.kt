package com.example.myapplication1.coroutines.ui.room

import com.example.myapplication1.coroutines.data.model.Mock_UserItem

class LockUserImpl(var mockDao: MockDao) :LocalUser{
    override suspend fun insertUser(userList: List<Mock_UserItem>) {
        mockDao.insertUser(userList)
    }

    override suspend fun getAllUser(): List<Mock_UserItem> {
       return mockDao.getUser()
    }
}