package com.example.kolesaparser.repository

import com.example.kolesaparser.domain.models.SearchProperties

class DefaultCarRepository(
    private val searchPropertiesDao: SearchPropertiesDao
) : SearchPropertiesRepository {

    override fun updateProperties(searchProperties: SearchProperties) {
        searchPropertiesDao.insert(searchProperties)
    }

    override fun getProperties() = searchPropertiesDao.getProperties()

}