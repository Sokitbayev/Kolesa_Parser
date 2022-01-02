package com.example.kolesaparser.ui.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.kolesaparser.domain.models.Car
import kotlinx.android.synthetic.main.result_item.view.*

class ResultItemViewHolder(
    itemView: View,
    private val onItemClick: (Car) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private val container get() = itemView.result_item_container
    private val priceText get() = itemView.result_item_price

    fun bind(item: Car) {
        priceText.text = item.price.toString()
        container.setOnClickListener {
            onItemClick(item)
        }
    }
}