package com.example.kolesaparser.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "search_result_table")
data class SearchResult(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "car") val car: Car
)