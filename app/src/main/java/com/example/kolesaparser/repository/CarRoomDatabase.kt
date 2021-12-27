package com.example.kolesaparser.repository

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Car::class], version = 1, exportSchema = false)
abstract class CarRoomDatabase : RoomDatabase() {

    abstract val carDao: CarDao

    /*companion object {

        @Volatile
        private var INSTANCE: CarRoomDatabase? = null

        fun getDatabase(context: Context): CarRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CarRoomDatabase::class.java,
                    "car_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }*/
}