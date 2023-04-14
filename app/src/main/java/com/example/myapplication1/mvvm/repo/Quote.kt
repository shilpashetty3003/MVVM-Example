package com.example.myapplication1.mvvm.repo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Quote")
data class Quote (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val text:String,val author:String)
