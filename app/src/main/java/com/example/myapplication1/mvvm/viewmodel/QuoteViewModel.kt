package com.example.myapplication1.mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication1.mvvm.model.Quotes

import com.example.myapplication1.mvvm.repo.Quote
import com.example.myapplication1.mvvm.repo.QuoteRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteViewModel(var quoteRepo: QuoteRepo) :ViewModel(){

    var mutableLiveData:LiveData<List<Quote>> = quoteRepo.getQuote()



    fun insertQuote(quote: Quote){
        quoteRepo.insertQuote(quote)
    }
   init {
       viewModelScope.launch(Dispatchers.IO) {
           quoteRepo.getQuoteFromApi()
       }

   }

    val quoteApiResult_:LiveData<Quotes>
        get()=quoteRepo.quoteApiResult_

}