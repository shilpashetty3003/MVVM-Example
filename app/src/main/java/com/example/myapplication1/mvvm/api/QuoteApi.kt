package com.example.myapplication1.mvvm.api

import com.example.myapplication1.mvvm.model.Quotes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApi {


    @GET("/quotes")
    suspend fun getQuotes(@Query("page")page:Int):Response<Quotes>
}