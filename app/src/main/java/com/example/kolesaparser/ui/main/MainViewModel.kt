package com.example.kolesaparser.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kolesaparser.core.ViewState
import com.example.kolesaparser.domain.CarSearcher
import com.example.kolesaparser.domain.models.Car
import com.example.kolesaparser.domain.models.SearchProperties
import com.example.kolesaparser.repository.SearchPropertiesRepository
import com.example.kolesaparser.repository.SearchResultRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class MainViewModel(
    private val searchPropertiesRepository: SearchPropertiesRepository,
    private val searchResultRepository: SearchResultRepository,
    private val carSearcher: CarSearcher,
    private val ioContext: CoroutineContext = Dispatchers.IO
) : ViewModel() {

    private val _viewState = MutableLiveData<ViewState<MainViewState>>()

    val viewState: LiveData<ViewState<MainViewState>> = _viewState

    init {
        checkSearchResult()
    }

    private fun checkSearchResult() {
        viewModelScope.launch {
            withContext(ioContext) {
                val searchResult = searchResultRepository.getCars() ?: return@withContext
                val cars = arrayListOf<Car>()
                searchResult.forEach {
                    cars.add(it.car.copy(url = "https://kolesa.kz/" + it.car.url))
                }
                _viewState.postValue(ViewState.Data(MainViewState.SearchResult(cars)))
            }
        }
    }

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