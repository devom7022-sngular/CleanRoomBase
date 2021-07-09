package com.example.roombase.di.module.data

import com.example.roombase.data.config.IPreferences
import com.example.roombase.data.database.daos.PersonDao
import com.example.roombase.data.repositories.ApiRepository
import com.example.roombase.data.repositories.DataBaseRepository
import com.example.roombase.data.repositories.PreferencesRepository
import com.example.roombase.data.repositories.impl.ApiRepositoryImpl
import com.example.roombase.data.repositories.impl.DataBaseRepositoryImpl
import com.example.roombase.data.repositories.impl.PreferencesRepositoryImpl
import dagger.Module
import dagger.Provides

/**
 * RepositoryModule
 */
@Module
class RepositoryModule {

    /**
     * Method to provide api repository instance
     */
    @Provides
    fun provideApiRepository(): ApiRepository = ApiRepositoryImpl()

    /**
     * Method to provide preferences repository instance
     *
     * @param preferences IPreferences instance
     *
     * @return PreferencesRepositoryImpl
     */
    @Provides
    fun providePreferencesRepository(preferences: IPreferences): PreferencesRepository =
        PreferencesRepositoryImpl(preferences)

    /**
     * Method to provide data base repository instance
     *
     * @param personDao person dao instance
     *
     * @return DataBaseRepositoryImpl
     */
    @Provides
    fun provideDatabaseRepository(personDao: PersonDao): DataBaseRepository =
        DataBaseRepositoryImpl(personDao)
}