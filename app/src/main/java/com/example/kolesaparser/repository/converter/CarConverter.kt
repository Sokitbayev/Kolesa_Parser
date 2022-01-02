package com.example.kolesaparser.repository.converter

import androidx.room.TypeConverter
import com.example.kolesaparser.domain.models.Car
import com.google.gson.Gson

class RoomConverters {
    companion object {

        @TypeConverter
        @JvmStatic
        fun listToGson(value: MutableList<Car>): String = Gson().toJson(value)

        @TypeConverter
        @JvmStatic
        fun gsonToList(value: String) = Gson().fromJson(value, Array<Car>::class.java).toList()

        @TypeConverter
        @JvmStatic
        fun carToGson(value: Car): String = Gson().toJson(value)

        @TypeConverter
        @JvmStatic
        fun gsonToCar(value: String) = Gson().fromJson(value, Car::class.java)
    }
}