package com.example.myapplication1.mvvm.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Orientation
import com.example.myapplication1.QuoteAdapter
import com.example.myapplication1.R
import com.example.myapplication1.databinding.ActivityMvvmBinding
import com.example.myapplication1.mvvm.api.QuoteApi
import com.example.myapplication1.mvvm.api.RemoteDataSource
import com.example.myapplication1.mvvm.repo.Quote
import com.example.myapplication1.mvvm.repo.QuoteDatabase
import com.example.myapplication1.mvvm.repo.QuoteRepo
import com.example.myapplication1.mvvm.viewmodel.QuoteViewModel
import com.example.myapplication1.mvvm.viewmodel.QuoteViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MvvmActivity : AppCompatActivity() {
    lateinit var activityMvvmBinding: ActivityMvvmBinding
    lateinit var quoteViewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        activityMvvmBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm)

        var quoteApi = RemoteDataSource.getInstsnce().create(QuoteApi::class.java)

//        GlobalScope.launch {
//
//            var result = quoteApi.getQuotes(1)
//            Log.d("TAG", "onCreateresult: " + result.body())
//        }



        val quoteDao = QuoteDatabase.getInstance(applicationContext).quoteDao()
        val quoteRepo = QuoteRepo(quoteDao,quoteApi)
        quoteViewModel = ViewModelProvider(
            this,
            QuoteViewModelFactory(quoteRepo)
        ).get(QuoteViewModel::class.java)

        val rvQuote = findViewById<RecyclerView>(R.id.rvQuote)
        rvQuote.layoutManager = LinearLayoutManager(this)
        val adapter = QuoteAdapter()
        rvQuote.adapter = adapter

        var q1 = Quote(0, "A", "B")
        var q2 = Quote(1, "B", "CCC")
        adapter.submitList(listOf(q1, q2))

//        Handler(Looper.getMainLooper()).postDelayed(Runnable {
//
//            var q2 = Quote(1, "B", "CCC")
//            var q3 = Quote(1, "f", "CCC")
//            var q4 = Quote(1, "g", "CCC")
//            var q5 = Quote(1, "     ", "CCC")
//            adapter.submitList(listOf(q2, q3, q4, q5))
//            adapter.notifyDataSetChanged()
//        }, 5000)

        quoteViewModel.quoteApiResult_.observe(this, Observer {
            Log.d("TAG", "onCreatObservere: "+it)
            if(it!=null){
                var quote= ArrayList<Quote>()

                it.results.map {result->
                    Log.d("TAG", "onCreate: "+result.author)
                    quote.add(Quote(0,result.content,result.content))

                }
            //    Log.d("TAG", "onCreate: "+quote)
                adapter.submitList(quote)
            }
        })

    }

}