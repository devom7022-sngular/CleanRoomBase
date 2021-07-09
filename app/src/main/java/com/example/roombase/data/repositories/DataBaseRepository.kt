package com.example.roombase.data.repositories

import com.example.roombase.data.database.daos.PersonDao

/**
 * DataBaseRepository
 */
interface DataBaseRepository {

    /**
     * Method to get person dao instance
     *
     * @return person dao instance
     */
    fun personDao(): PersonDao
}