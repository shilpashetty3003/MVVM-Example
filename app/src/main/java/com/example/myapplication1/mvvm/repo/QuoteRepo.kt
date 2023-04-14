package com.example.myapplication1.mvvm.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication1.mvvm.api.QuoteApi
import com.example.myapplication1.mvvm.model.Quotes

class QuoteRepo(var quoteDao: QuoteDao, var quoteApi: QuoteApi) {

    val quoteApiResult = MutableLiveData<Quotes>()
    val quoteApiResult_:LiveData<Quotes>
    get() = quoteApiResult

    fun getQuote(): LiveData<List<Quote>> {
        return quoteDao.getAllQuote()
    }

    fun insertQuote(quote: Quote) {
        quoteDao.insertQuote(quote)
    }

    suspend fun getQuoteFromApi() {

        var result = quoteApi.getQuotes(1)
        if (result != null) {
            quoteApiResult.postValue(result.body())

        }

    }
}