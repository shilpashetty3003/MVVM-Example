package com.example.myapplication1.coroutines.ui.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication1.coroutines.data.model.Mock_UserItem

@Database(entities = [Mock_UserItem::class], version = 1)
abstract class MockDatabase : RoomDatabase() {

    abstract fun mockDao(): MockDao

    companion object {

        private var INSTANCE: MockDatabase? = null
        fun getInstance(context: Context): MockDatabase {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MockDatabase::class.java,
                        "mockDB"
                    ).build()
                }

            }
            return INSTANCE!!
        }
    }

}