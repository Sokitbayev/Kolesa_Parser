package com.example.kolesaparser.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.kolesaparser.domain.models.SearchProperties
import com.example.kolesaparser.domain.models.SearchResult
import com.example.kolesaparser.repository.converter.RoomConverters

@Database(
    entities = [SearchProperties::class, SearchResult::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(RoomConverters::class)
abstract class SearchPropertiesRoomDatabase : RoomDatabase() {

    abstract val searchPropertiesDao: SearchPropertiesDao

    abstract val searchResultDao: SearchResultDao

}