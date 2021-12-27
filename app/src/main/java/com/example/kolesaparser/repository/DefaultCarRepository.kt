package com.example.kolesaparser.repository

class DefaultCarRepository(
    private val carDao: CarDao
): CarRepository {

    override fun updateCarProperties(car: Car) {
        carDao.insert(car)
    }
}