package com.example.roombase.data.repositories.impl

import com.example.roombase.data.config.IPreferences
import com.example.roombase.data.repositories.PreferencesRepository
import javax.inject.Inject

/**
 * PreferencesRepositoryImpl
 *
 * @param preferences preferences instance
 */
class PreferencesRepositoryImpl @Inject constructor(
    private val preferences: IPreferences
) : PreferencesRepository {

    /**
     * Method to init preferences repository
     *
     * @param preferenceName preferences name
     *
     * @return this
     */
    override fun init(preferenceName: String): PreferencesRepository {
        preferences.init(preferenceName)
        return this
    }

    /**
     * Method to save string value
     *
     * @param key key for save in preferences
     * @param value value to save in preferences
     */
    override fun saveString(key: String, value: String) {
        preferences.saveString(key, value)
    }

    /**
     * Method to get string value
     *
     * @param key key for search value in preferences
     */
    override fun getString(key: String): String = preferences.getString(key) ?: ""
}