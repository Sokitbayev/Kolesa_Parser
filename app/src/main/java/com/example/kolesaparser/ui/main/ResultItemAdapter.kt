package com.example.kolesaparser.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.kolesaparser.R
import com.example.kolesaparser.domain.models.Car

class ResultItemAdapter(private val onItemClick: (Car) -> Unit) :
    ListAdapter<Car, ResultItemViewHolder>(ResultItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.result_item, parent, false)
        return ResultItemViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: ResultItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}