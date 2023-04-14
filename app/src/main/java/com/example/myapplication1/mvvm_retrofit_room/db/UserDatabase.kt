package com.example.myapplication1.mvvm_retrofit_room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication1.mvvm_retrofit_room.model.Users
import com.example.myapplication1.mvvm_retrofit_room.model.UsersItem

@Database(entities = [UsersItem::class], version = 1)
abstract class UserDatabase :RoomDatabase() {

    abstract fun userDao():UserDao

    companion object{
        var INSTANCE:UserDatabase?=null

        fun getInstance(context: Context):UserDatabase{
            synchronized(this){
                INSTANCE=Room.databaseBuilder(context.applicationContext,UserDatabase::class.java,"UserDetails").build()
            }
            return  INSTANCE!!

        }
    }
}