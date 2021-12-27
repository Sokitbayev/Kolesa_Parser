package com.example.kolesaparser.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CarDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(car: Car)

    @Query("select * from carTable")
    fun getCar(): Car
}