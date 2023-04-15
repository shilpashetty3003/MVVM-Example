package com.example.myapplication1.mvp.contract

interface ContractInterface {
    interface View{
        fun initView()
        fun updateView()
    }
    interface  Presenter{
        fun getValue():String
        fun incrementValue()
    }
    interface  Model{
        fun getIncrementCount():String
        fun incrementCount()
    }
}