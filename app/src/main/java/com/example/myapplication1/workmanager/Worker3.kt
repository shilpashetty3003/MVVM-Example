package com.example.myapplication1.workmanager

import android.annotation.SuppressLint
import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class Worker3(var context:Context,var workParameters:WorkerParameters) :Worker(context,workParameters) {
    @SuppressLint("RestrictedApi")
    override fun doWork(): Result {

        return try {
            Result.Success(createOutputData("21","female"))
        }
        catch (e:Exception){
            Result.Failure(createOutputData("error","error"))
        }
    }

    fun createOutputData(data1:String,data2:String): Data {
        return  Data.Builder().putString(WorkerKeys.Age.toString(),data1).putString(WorkerKeys.Gender.toString(),data2).build()

    }
}