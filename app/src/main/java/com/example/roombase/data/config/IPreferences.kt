package com.example.roombase.data.config

/**
 * IPreferences
 */
interface IPreferences {

    /**
     * Method to init preferences
     *
     * @param preferenceName preference name
     */
    fun init(preferenceName: String)

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
    fun getString(key: String): String?
}