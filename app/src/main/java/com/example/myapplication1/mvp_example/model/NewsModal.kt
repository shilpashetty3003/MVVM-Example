package com.example.myapplication1.mvp_example.model

import android.util.Log
import com.example.myapplication1.mvp_example.contractor.NewsContractor
import com.example.myapplication1.mvvm_retrofit_room.db.UserDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewsModal(var userDao: UserDao) {

    fun getDataFromDatabase(model: NewsContractor.Model) {
        GlobalScope.launch {
            try {
                model.onSuccess(userDao.getUsers())
            } catch (error: Error) {
                model.onFailure("Error while fetching daata")
            }
        }
    }
}