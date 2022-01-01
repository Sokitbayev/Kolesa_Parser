package com.example.kolesaparser.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.kolesaparser.domain.CarSearcher
import com.example.kolesaparser.repository.Car
import com.example.kolesaparser.repository.CarDao
import com.example.kolesaparser.worker.SEARCH_WORKER_TAG
import com.example.kolesaparser.worker.SearchWorker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit
import kotlin.coroutines.CoroutineContext

class MainViewModel(
    val carDao: CarDao,
    private val carSearcher: CarSearcher,
    private val ioContext: CoroutineContext = Dispatchers.IO
) : ViewModel() {

    fun onUpdateData(url: String, price: Int) {
        viewModelScope.launch {
            withContext(ioContext) {
                carSearcher.getCarList(url)
            }
        }
    }
}