package com.example.kolesaparser.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.kolesaparser.repository.CarRepository
import kotlinx.coroutines.delay
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

const val SEARCH_WORKER_TAG = "SEARCH_WORKER_TAG"

@KoinApiExtension
class SearchWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params),
    KoinComponent {

    private val carRepository: CarRepository by inject()

    override suspend fun doWork(): Result {
        val applicationContext = applicationContext
        delay(5000)
        return try {
            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }
}