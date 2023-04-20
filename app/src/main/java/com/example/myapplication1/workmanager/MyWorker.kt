package com.example.myapplication1.workmanager

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.ListenableWorker.Result.Failure
import androidx.work.ListenableWorker.Result.failure
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    val TAG = "DoWork"

    @SuppressLint("RestrictedApi")
    override fun doWork(): Result {
        return try {
            val name = inputData.getString("name")
            Log.d("TAG", "doWorkname: " + name)
            Result.Success(createOutputData("Shetty"))

        } catch (e: Exception) {
            Result.Failure(createOutputData("error"))
        }
    }

    fun createOutputData(data: String): Data {
        return Data.Builder().putString("name", data).build()
    }
}