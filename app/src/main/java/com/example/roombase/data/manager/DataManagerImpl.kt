package com.example.roombase.data.manager

import com.example.roombase.data.repositories.ApiRepository
import com.example.roombase.data.repositories.DataBaseRepository
import com.example.roombase.data.repositories.PreferencesRepository
import javax.inject.Inject

/**
 * DataManagerImpl
 */
class DataManagerImpl @Inject constructor(
    private val apiRepository: ApiRepository,
    private val preferencesRepository: PreferencesRepository,
    private val databaseRepository: DataBaseRepository
) : DataManager {

    /**
     * Method to get api repository
     *
     * @return api repository instance
     */
    override fun getApiRepository(): ApiRepository = apiRepository

    /**
     * Method to get preferences repository
     *
     * @return preferences repository instance
     */
    override fun getPreferencesRepository(): PreferencesRepository = preferencesRepository

    /**
     * Method to get db repository
     * Executes db queries of all application
     *
     * @return db repository instance
     */
    override fun getDBRepository(): DataBaseRepository = databaseRepository
}