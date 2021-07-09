package com.example.roombase.data.repositories

/**
 * PreferencesRepository
 */
interface PreferencesRepository {

    /**
     * Method to init preferences repository
     *
     * @param preferenceName preferences name
     *
     * @return this
     */
    fun init(preferenceName: String): PreferencesRepository

    /**
     * Method to save string value
     *
     * @param key key for save in preferences
     * @param value value to save in preferences
     */
    fun saveString(key: String, value: String)

    /**
     * Method to get string value
     *
     * @param key key for search value in preferences
     */
    fun getString(key: String): String
}