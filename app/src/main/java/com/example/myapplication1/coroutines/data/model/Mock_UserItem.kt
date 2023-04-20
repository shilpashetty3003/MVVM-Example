package com.example.myapplication1.coroutines.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Mock")
data class Mock_UserItem(

    val avatar: String?,
    val device_Token: String?,
    val email: String?,
    @PrimaryKey
    val id: String,
    val name: String?,
    val userId: String?,
    val userToken: String?
)