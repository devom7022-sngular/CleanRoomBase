package com.example.roombase.data.manager

import com.example.roombase.data.repositories.ApiRepository
import com.example.roombase.data.repositories.DataBaseRepository
import com.example.roombase.data.repositories.PreferencesRepository

/**
 * DataManager
 */
interface DataManager {

    /**
     * Method to get api repository
     *
     * @return api repository instance
     */
    fun getApiRepository(): ApiRepository

    /**
     * Method to get preferences repository
     *
     * @return preferences repository instance
     */
    fun getPreferencesRepository(): PreferencesRepository

    /**
     * Method to get db repository
     * Executes db queries of all application
     *
     * @return db repository instance
     */
    fun getDBRepository(): DataBaseRepository
}