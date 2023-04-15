package com.example.myapplication1.mvp_example.contractor

import com.example.myapplication1.mvvm_retrofit_room.model.UsersItem

interface NewsContractor {

    interface View{
        fun showProgress()
        fun hideProgress()
        fun getError(error:String)
        fun setData(listdata:List<UsersItem>)
    }

    interface Model{
        fun onSuccess(listData:List<UsersItem>)
        fun onFailure(error: String)

    }
}