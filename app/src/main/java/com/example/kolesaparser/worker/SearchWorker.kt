package com.example.kolesaparser.worker

import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.*
import com.example.kolesaparser.R
import kotlinx.coroutines.delay

const val SEARCH_WORKER_TAG = "SEARCH_WORKER_TAG"

class SearchWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {

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