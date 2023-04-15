package com.example.myapplication1.mvp_example.presenter

import com.example.myapplication1.mvp_example.contractor.NewsContractor
import com.example.myapplication1.mvp_example.model.NewsModal
import com.example.myapplication1.mvvm_retrofit_room.model.UsersItem

class NewsPresenter(var _view:NewsContractor.View,var newsModal: NewsModal):NewsContractor.Model {



    fun getData(){
        _view.showProgress()
        newsModal.getDataFromDatabase(this)
    }
    override fun onSuccess(listData: List<UsersItem>) {
       _view.hideProgress()
        _view.setData(listData)
    }

    override fun onFailure(error: String) {
       _view.hideProgress()
        _view.getError(error)
    }
}