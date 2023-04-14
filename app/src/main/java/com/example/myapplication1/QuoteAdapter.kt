package com.example.myapplication1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.databinding.SingleRowBinding
import com.example.myapplication1.mvvm.repo.Quote

class QuoteAdapter : ListAdapter<Quote, QuoteAdapter.QuoteViewHolder>(Comparator()) {
    lateinit var binding: SingleRowBinding

    class QuoteViewHolder(var binding: SingleRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(quote: Quote) {
            binding.quote = quote
        }
    }

    class Comparator : DiffUtil.ItemCallback<Quote>() {
        override fun areItemsTheSame(oldItem: Quote, newItem: Quote): Boolean {
            return oldItem.id == newItem.id

        }

        override fun areContentsTheSame(oldItem: Quote, newItem: Quote): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        binding = SingleRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        var item = getItem(position)
        holder.bind(item)
    }




}