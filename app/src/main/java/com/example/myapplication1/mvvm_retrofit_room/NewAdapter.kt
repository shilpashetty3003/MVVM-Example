package com.example.myapplication1.mvvm_retrofit_room

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.databinding.SingleNewsRowBinding
import com.example.myapplication1.mvp_example.model.NewsModal
import com.example.myapplication1.mvvm_retrofit_room.model.UsersItem

class NewAdapter(var newsList:List<UsersItem>,var listener:(UsersItem) ->Unit):RecyclerView.Adapter<NewAdapter.NewsViewHolder>() {


    lateinit var binding: SingleNewsRowBinding

    class NewsViewHolder(var binding:SingleNewsRowBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(usersItem: UsersItem,listeners: (UsersItem) -> Unit)= with(binding.btnClick)
        {
            binding.userItem = usersItem
            binding.btnClick.setOnClickListener { listeners(usersItem)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
      binding= SingleNewsRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return newsList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        var item=newsList[position]
        holder.bind(item,listener)

    }
}