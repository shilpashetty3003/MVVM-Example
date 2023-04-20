package com.example.myapplication1.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.myapplication1.R

class WorkManagerExample : AppCompatActivity() {
    val TAG = "WorkEXample"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager_example)
        val work1= OneTimeWorkRequestBuilder<Worker1>().build()
        val work2= OneTimeWorkRequestBuilder<Worker2>().build()
        val work3= OneTimeWorkRequestBuilder<Worker3>().build()
        val workManager:WorkManager ? = WorkManager.getInstance()
        val list= mutableListOf<OneTimeWorkRequest>()
        list.add(work1)
        list.add(work3)
        workManager?.beginWith(list)?.then(work2)?.enqueue()
    }

    fun createInputData(): Data {
        return Data.Builder().putString("name", "Shilpa").build()
    }

}