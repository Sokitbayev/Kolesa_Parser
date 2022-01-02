package com.example.kolesaparser.repository

import com.example.kolesaparser.domain.models.SearchProperties

class DefaultSearchPropertiesRepository(
    private val searchPropertiesDao: SearchPropertiesDao
) : SearchPropertiesRepository {

    override fun updateProperties(searchProperties: SearchProperties) {
        searchPropertiesDao.insert(searchProperties)
    }

    override fun getProperties() = searchPropertiesDao.getProperties()

}