package com.example.myapplication1.mvvm_retrofit_room.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication1.mvvm_retrofit_room.model.Users
import com.example.myapplication1.mvvm_retrofit_room.model.UsersItem


@Dao
interface UserDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user:List<UsersItem>)


    @Query("select * from Users")
    fun getUsers():List<UsersItem>
}