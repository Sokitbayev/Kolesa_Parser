package com.example.kolesaparser.ui.main

import androidx.recyclerview.widget.DiffUtil
import com.example.kolesaparser.domain.models.Car

class ResultItemDiffUtil : DiffUtil.ItemCallback<Car>() {

    override fun areItemsTheSame(oldItem: Car, newItem: Car): Boolean {
        return oldItem.url == oldItem.url
                && oldItem.price == oldItem.price
    }

    override fun areContentsTheSame(oldItem: Car, newItem: Car): Boolean {
        return oldItem == newItem
    }
}