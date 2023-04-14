package com.example.myapplication1.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication1.mvvm.repo.QuoteRepo

class QuoteViewModelFactory(var quoteRepo: QuoteRepo):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuoteViewModel(quoteRepo) as T
    }
}