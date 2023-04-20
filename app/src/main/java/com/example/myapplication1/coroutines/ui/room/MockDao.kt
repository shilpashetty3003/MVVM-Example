package com.example.myapplication1.coroutines.ui.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication1.coroutines.data.model.Mock_UserItem

@Dao
interface MockDao {


    @Insert
    suspend fun insertUser(userList:List<Mock_UserItem>)

    @Query("select * from Mock")
    suspend fun getUser():List<Mock_UserItem>
}