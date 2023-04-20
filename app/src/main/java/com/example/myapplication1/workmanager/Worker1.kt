package com.example.myapplication1.workmanager

import android.annotation.SuppressLint
import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class Worker1(var context: Context, var workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    @SuppressLint("RestrictedApi")
    override fun doWork(): Result {
        return try {


            Result.Success(createOutput("Shilpa","Shetty"))
        } catch (e: Exception) {
            Result.Failure(createOutput("Error","error"))
        }
    }
    fun createOutput(data1:String,data2:String):Data{
        return  Data.Builder().putString(WorkerKeys.Name.toString(),data1).putString(WorkerKeys.LastName.toString(),data2).build()
    }
}
