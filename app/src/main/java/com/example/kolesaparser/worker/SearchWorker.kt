package com.example.kolesaparser.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.kolesaparser.domain.CarSearcher
import com.example.kolesaparser.domain.models.Car
import com.example.kolesaparser.repository.SearchPropertiesRepository
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

const val SEARCH_WORKER_TAG = "SEARCH_WORKER_TAG"

@KoinApiExtension
class SearchWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params),
    KoinComponent {

    private val searchPropertiesRepository: SearchPropertiesRepository by inject()
    private val carSearcher: CarSearcher by inject()

    override suspend fun doWork(): Result {
        val applicationContext = applicationContext
        return try {
            val searchProperties = searchPropertiesRepository.getProperties()
            val newCarList = carSearcher.getCarList(searchProperties.url)
            val newCars = getNewCars(newCarList, searchProperties.cars)

            searchPropertiesRepository.updateProperties(searchProperties.copy(cars = newCarList))

            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }

    private fun getNewCars(newList: List<Car>, oldList: MutableList<Car>): List<Car> {
        return newList.filterNot { oldList.contains(it) }
    }
}