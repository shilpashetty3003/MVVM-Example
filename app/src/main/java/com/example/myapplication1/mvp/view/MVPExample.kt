package com.example.myapplication1.mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.myapplication1.R
import com.example.myapplication1.databinding.ActivityMvpexampleBinding
import com.example.myapplication1.mvp.contract.ContractInterface
import com.example.myapplication1.mvp.presenter.MainActivityPresenter

class MVPExample : AppCompatActivity(), ContractInterface.View {


    var mainActivityPresenter: MainActivityPresenter? = null
    lateinit var tvValue: TextView
    lateinit var btnValue: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_mvpexample)
        tvValue = findViewById(R.id.tvValue)
        btnValue = findViewById(R.id.btnValue)
        mainActivityPresenter = MainActivityPresenter(this)
    }

    override fun initView() {
        tvValue.text = mainActivityPresenter?.getValue()
        btnValue.setOnClickListener { mainActivityPresenter?.incrementValue() }

    }

    override fun updateView() {
        tvValue.text = mainActivityPresenter?.getValue()
    }
}