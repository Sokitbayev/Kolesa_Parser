package com.example.kolesaparser.repository

import com.example.kolesaparser.domain.models.Car
import com.example.kolesaparser.domain.models.SearchResult

interface SearchResultRepository {

    fun addCars(cars: List<Car>)

    fun getCars(): List<SearchResult>?

}