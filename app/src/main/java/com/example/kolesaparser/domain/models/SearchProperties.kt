package com.example.kolesaparser.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "searchPropertiesTable")
data class SearchProperties(
    @PrimaryKey(autoGenerate = false) val id:Int = 0,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "price") val targetPrice: Int,
    @ColumnInfo(name = "carList") val cars: MutableList<Car>
)