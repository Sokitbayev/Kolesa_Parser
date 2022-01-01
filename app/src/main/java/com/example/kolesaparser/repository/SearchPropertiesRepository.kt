package com.example.kolesaparser.repository

import com.example.kolesaparser.domain.models.Car
import com.example.kolesaparser.domain.models.SearchProperties

interface SearchPropertiesRepository {

    fun updateProperties(searchProperties: SearchProperties)

    fun getProperties(): SearchProperties
}