package com.example.myapplication1.coroutines.utils

sealed class ResponseState<out T> {

    class Loading<T> : ResponseState<T>()

    class Success<T>(var data: T) : ResponseState<T>()
    class Failure<T>(var error: String) : ResponseState<T>()

}