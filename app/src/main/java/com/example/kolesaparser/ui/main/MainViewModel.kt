package com.example.kolesaparser.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kolesaparser.repository.Car
import com.example.kolesaparser.repository.CarDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class MainViewModel(
    val carDao: CarDao,
    private val ioContext: CoroutineContext = Dispatchers.IO
) : ViewModel() {

    fun onUpdateData(url: String, price: Int) {
        viewModelScope.launch {
            withContext(ioContext) {
                carDao.insert(Car(url = url, price = price))
            }
        }

    }
}