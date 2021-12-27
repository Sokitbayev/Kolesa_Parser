package com.example.kolesaparser.repository

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "carTable")
data class Car(
    @PrimaryKey(autoGenerate = true) val id:Int = 0,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "price") val price: Int
)
