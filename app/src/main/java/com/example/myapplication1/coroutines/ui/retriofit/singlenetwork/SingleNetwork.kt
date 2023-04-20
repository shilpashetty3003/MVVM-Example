package com.example.myapplication1.coroutines.ui.retriofit.singlenetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Orientation
import com.example.myapplication1.R
import com.example.myapplication1.coroutines.data.api.ApiInterfaceImpl
import com.example.myapplication1.coroutines.data.api.RemoteSource
import com.example.myapplication1.coroutines.data.model.Mock_UserItem
import com.example.myapplication1.coroutines.ui.room.LockUserImpl
import com.example.myapplication1.coroutines.ui.room.MockDatabase
import com.example.myapplication1.coroutines.utils.ApiAdapter
import com.example.myapplication1.coroutines.utils.ResponseState
import com.example.myapplication1.coroutines.viewmodels.SingleNetworkVIewModel
import com.example.myapplication1.coroutines.viewmodels.ViewModelFactory
import com.example.myapplication1.databinding.ActivitySingleNetworkBinding

class SingleNetwork : AppCompatActivity() {

    lateinit var singleNetworkVIewModel: SingleNetworkVIewModel
    lateinit var binding: ActivitySingleNetworkBinding
    lateinit var adapter: ApiAdapter

    private val TAG = "SingleNetwork"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_single_network)

        setUpUI()
        setViewModels()
        setUpObserver()
    }

    private fun setUpObserver() {
        singleNetworkVIewModel.getUserDetails().observe(this, Observer {
            when (it) {
                is ResponseState.Failure -> {
                    binding.pbUser.visibility = View.GONE
                    Toast.makeText(this, "${it.error}", Toast.LENGTH_LONG).show()
                }
                is ResponseState.Loading -> {
                    binding.pbUser.visibility = View.VISIBLE
                }
                is ResponseState.Success -> {
                    binding.pbUser.visibility = View.GONE
                    updateAdapter(it.data)
                }
            }
        })
    }

    private fun setViewModels() {
        singleNetworkVIewModel = ViewModelProvider(
            this,
            ViewModelFactory(ApiInterfaceImpl(RemoteSource.userService), LockUserImpl(MockDatabase.getInstance(this).mockDao()))
        )[SingleNetworkVIewModel::class.java]
    }

    private fun setUpUI() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_single_network)
        binding.rvUser.layoutManager = LinearLayoutManager(this)
        adapter =
            ApiAdapter(
                arrayListOf(
                )
            )

        binding.rvUser.addItemDecoration(DividerItemDecoration(
            binding.rvUser.context,(binding.rvUser.layoutManager as LinearLayoutManager).orientation
        ))

    }

    fun updateAdapter(userList: List<Mock_UserItem>) {

        adapter = ApiAdapter(userList)
        binding.rvUser.adapter = adapter
    }
}