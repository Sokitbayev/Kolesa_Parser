package com.example.kolesaparser.repository

import com.example.kolesaparser.domain.models.Car
import com.example.kolesaparser.domain.models.SearchResult

class DefaultSearchResultRepository(
    private val searchResultDao: SearchResultDao
) : SearchResultRepository{

    override fun addCars(cars: List<Car>) {
        cars.forEach{
            searchResultDao.insert(SearchResult(car = it))
        }
    }

    override fun getCars() = searchResultDao.getCars()

}