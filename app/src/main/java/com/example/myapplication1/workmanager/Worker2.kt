package com.example.myapplication1.workmanager

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class Worker2(var context:Context,var workerParameters: WorkerParameters):Worker(context,workerParameters) {
    @SuppressLint("RestrictedApi")
    override fun doWork(): Result {

        return try {
            val name=inputData.getString(WorkerKeys.Name.toString())
            val last=inputData.getString(WorkerKeys.LastName.toString())
            val age=inputData.getString(WorkerKeys.Age.toString())
            val gender=inputData.getString(WorkerKeys.Gender.toString())
            Log.d("TAG", "doWork: ${name} -- ${last} -- ${age} -- ${gender}")
            Result.Success()
        }catch (e:java.lang.Exception){
            Result.Failure()
        }
    }
}