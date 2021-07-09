package com.example.roombase.di.module.ui

import android.app.Application
import android.content.Context
import com.example.roombase.data.config.IPreferences
import com.example.roombase.ui.app.PreferencesConfig
import dagger.Module
import dagger.Provides

/**
 * AppModule
 */
@Module
class AppModule {

    /**
     * Method to provide app context
     *
     * @param app application instance
     *
     * @return context
     */
    @Provides
    fun provideContext(app: Application): Context = app

    /**
     * Method to provide preferences config
     *
     * @param context context instance
     *
     * @return preferences instance
     */
    @Provides
    fun providePreferences(context: Context): IPreferences = PreferencesConfig(context)

}
