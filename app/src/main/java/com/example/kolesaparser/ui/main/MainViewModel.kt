package com.example.kolesaparser.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kolesaparser.domain.CarSearcher
import com.example.kolesaparser.domain.models.SearchProperties
import com.example.kolesaparser.repository.SearchPropertiesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class MainViewModel(
    private val searchPropertiesRepository: SearchPropertiesRepository,
    private val carSearcher: CarSearcher,
    private val ioContext: CoroutineContext = Dispatchers.IO
) : ViewModel() {

    fun onUpdateData(url: String, price: Int) {
        viewModelScope.launch {
            withContext(ioContext) {
                val cars = carSearcher.getCarList(url)
                val searchProperties = SearchProperties(url = url, targetPrice = price, cars = cars)
                searchPropertiesRepository.updateProperties(searchProperties)
            }
        }
    }
}