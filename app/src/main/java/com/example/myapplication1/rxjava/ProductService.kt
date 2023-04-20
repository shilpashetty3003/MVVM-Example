package com.example.myapplication1.rxjava


import io.reactivex.Observable
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    fun getProducts(): Observable<List<Products>>
}