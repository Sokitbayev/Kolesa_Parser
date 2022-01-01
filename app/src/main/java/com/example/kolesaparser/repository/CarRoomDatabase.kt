package com.example.kolesaparser.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.kolesaparser.domain.models.SearchProperties
import com.example.kolesaparser.repository.mapper.RoomConverters

@Database(entities = [SearchProperties::class], version = 1, exportSchema = true)
@TypeConverters(RoomConverters::class)
abstract class SearchPropertiesRoomDatabase : RoomDatabase() {

    abstract val searchPropertiesDao: SearchPropertiesDao

}