package com.example.myapplication1.mvp.presenter

import com.example.myapplication1.mvp.contract.ContractInterface
import com.example.myapplication1.mvp.model.MainActivityModel

class MainActivityPresenter(view_: ContractInterface.View):ContractInterface.Presenter {


    var model=MainActivityModel()
    var view:ContractInterface.View=view_

    init {
        view.initView()
    }
    override fun getValue(): String {
       return model.getIncrementCount()
    }

    override fun incrementValue() {
        model.incrementCount()
        view.updateView()
    }
}