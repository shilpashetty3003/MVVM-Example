package com.example.myapplication1.mvvm_retrofit_room.utils

sealed class Resource<T>(var data: T? = null, var errorMessage: String? = null) {


    class Loading<T> : Resource<T>()
    class Success<T>(data: T?=null) : Resource<T>()
    class Failure<T>(error: String?=null) : Resource<T>()


}