package com.example.kolesaparser.ui.main

import com.example.kolesaparser.domain.models.Car

sealed class MainViewState {

    data class SearchResult(val cars: List<Car>) : MainViewState()
    data class InitialSearchProperties(val url: String, val price: Int) : MainViewState()
    object WorkerInit : MainViewState()
}