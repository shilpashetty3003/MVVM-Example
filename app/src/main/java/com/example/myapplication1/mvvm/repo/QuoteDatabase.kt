package com.example.myapplication1.mvvm.repo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase :RoomDatabase() {

    abstract fun quoteDao():QuoteDao

    companion object{
        private var INSTANCE: QuoteDatabase? =null

        fun getInstance(context:Context): QuoteDatabase {
            if (INSTANCE==null){
                synchronized(this){
                    INSTANCE=Room.databaseBuilder(context.applicationContext,QuoteDatabase::class.java,"QuoteDB").build()
                }
            }
            return INSTANCE!!
        }
    }
}