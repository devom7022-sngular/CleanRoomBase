package com.example.roombase.di.module.data

import com.example.roombase.data.manager.DataManager
import com.example.roombase.data.manager.DataManagerImpl
import com.example.roombase.data.repositories.ApiRepository
import com.example.roombase.data.repositories.DataBaseRepository
import com.example.roombase.data.repositories.PreferencesRepository
import dagger.Module
import dagger.Provides

/**
 * DataManagerModule
 */
@Module
class DataManagerModule {

    /**
     * Method to provide data manager
     *
     * @param apiRepository api repository instance
     * @param preferencesRepository preferences repository instance
     * @param dataBaseRepository data base repository instance
     *
     * @return DataManager
     */
    @Provides
    fun provideDataManager(
        apiRepository: ApiRepository,
        preferencesRepository: PreferencesRepository,
        dataBaseRepository: DataBaseRepository
    ): DataManager = DataManagerImpl(apiRepository, preferencesRepository, dataBaseRepository)
}