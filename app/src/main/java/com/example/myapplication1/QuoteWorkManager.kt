package com.example.myapplication1

import android.content.Context
import android.util.Log
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class QuoteWorkManager(var context: Context,var params:WorkerParameters): Worker(context,params) {
    var count:Int=0
    override fun doWork(): Result {
        count++
        Log.d("TAG", "doWork1234444: "+count)
        var userRepo=(context as MyApplication).userRepo
        CoroutineScope(Dispatchers.IO).launch {
            userRepo.getDataInBackground()
        }
        return  Result.success()
    }
}