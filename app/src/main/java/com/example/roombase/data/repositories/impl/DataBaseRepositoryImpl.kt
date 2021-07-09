package com.example.roombase.data.repositories.impl

import com.example.roombase.data.database.daos.PersonDao
import com.example.roombase.data.repositories.DataBaseRepository
import javax.inject.Inject

/**
 * DataBaseRepositoryImpl
 *
 * @param personDao person dao instance
 */
class DataBaseRepositoryImpl @Inject constructor(
    private val personDao: PersonDao
) : DataBaseRepository {

    /**
     * Method to get person dao instance
     *
     * @return person dao instance
     */
    override fun personDao(): PersonDao = personDao
}