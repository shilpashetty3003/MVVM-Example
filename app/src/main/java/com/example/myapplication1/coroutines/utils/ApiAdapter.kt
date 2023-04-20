package com.example.myapplication1.coroutines.utils

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.coordinatorlayout.R
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.coroutines.data.model.Mock_UserItem
import com.example.myapplication1.coroutines.ui.retriofit.singlenetwork.SingleNetwork
import com.example.myapplication1.databinding.SingleMockUserBinding

class ApiAdapter(var userList: List<Mock_UserItem>) :
    RecyclerView.Adapter<ApiAdapter.APIViewHolder>() {
    lateinit var binding: SingleMockUserBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): APIViewHolder {
        binding = SingleMockUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return APIViewHolder(binding)
    }


    override fun getItemCount(): Int {
        Log.d("TAG", "getItemCount: " + userList.size)
        return userList.size
    }

    override fun onBindViewHolder(holder: APIViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    fun updateList(userData: List<Mock_UserItem>) {
        userList=userData
        Log.d("TAG", "updateListuserList: "+userList)

    }

    class APIViewHolder(val binding: SingleMockUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mockList: Mock_UserItem) {
            Log.d("TAG", "bind:mockList " + mockList)
            binding.mockuser = mockList
        }
    }
}

