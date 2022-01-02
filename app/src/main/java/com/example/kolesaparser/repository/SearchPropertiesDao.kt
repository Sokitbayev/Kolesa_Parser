package com.example.kolesaparser.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kolesaparser.domain.models.Car
import com.example.kolesaparser.domain.models.SearchProperties

@Dao
interface SearchPropertiesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(searchProperties: SearchProperties)

    @Query("select * from searchPropertiesTable")
    fun getProperties(): SearchProperties
}