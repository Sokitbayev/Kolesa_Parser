package com.example.kolesaparser.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kolesaparser.domain.models.SearchResult

@Dao
interface SearchResultDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(cars: SearchResult)

    @Query("select * from search_result_table")
    fun getCars(): List<SearchResult>
}