package com.example.myapplication1.mvvm.repo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface QuoteDao {

    @Insert
    fun insertQuote(quote: Quote)

    @Query("select * from Quote")
    fun getAllQuote():LiveData<List<Quote>>
}