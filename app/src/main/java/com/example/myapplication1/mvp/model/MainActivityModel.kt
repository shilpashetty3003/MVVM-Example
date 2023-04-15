package com.example.myapplication1.mvp.model

import com.example.myapplication1.mvp.contract.ContractInterface

class MainActivityModel:ContractInterface.Model {

    var count:Int=0
    override fun getIncrementCount(): String {
        return count.toString()
    }

    override fun incrementCount() {
        count++
    }
}