package com.example.roombase.ui.app

import android.content.Context
import android.content.SharedPreferences
import com.example.roombase.data.config.IPreferences

/**
 * PreferencesConfig
 *
 * @param context
 */
class PreferencesConfig(val context: Context) : IPreferences {

    /**
     * Shared Preferences object
     */
    private var mPreferences: SharedPreferences? = null

    /**
     * Method to init preferences
     *
     * @param preferenceName preference name
     */
    override fun init(preferenceName: String) {
        mPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE)
    }

    /**
     * Method to save string value
     *
     * @param key key for save in preferences
     * @param value value to save in preferences
     */
    override fun saveString(key: String, value: String) {
        try {
            val editor = mPreferences?.edit()
            editor?.putString(key, value)
            editor?.apply()
        } catch (e: Exception) {
            // Empty catch
        }
    }

    override fun getString(key: String): String? =
        try {
            mPreferences?.getString(key, "")
        } catch (e: Exception) { "" }
}