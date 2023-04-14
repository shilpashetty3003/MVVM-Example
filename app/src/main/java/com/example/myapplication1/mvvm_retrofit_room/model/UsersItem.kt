package com.example.myapplication1.mvvm_retrofit_room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class UsersItem(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val email: String,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)