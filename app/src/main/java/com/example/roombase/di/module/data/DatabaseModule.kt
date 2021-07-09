package com.example.roombase.di.module.data

import android.content.Context
import androidx.room.Room
import com.example.roombase.data.database.AppDatabase
import com.example.roombase.data.database.daos.PersonDao
import dagger.Module
import dagger.Provides

/**
 * DatabaseModule
 */
@Module
class DatabaseModule {

    /**
     * Method to provide Room database
     *
     * @param context context instance
     *
     * @return app database
     */
    @Provides
    fun provideRoomDatabase(context: Context): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, AppDatabase.DB_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    /**
     * Method to provide person dao from app database instance
     *
     * @param appDatabase app database instance
     *
     * @return person dao instance
     */
    @Provides
    fun providePersonDao(appDatabase: AppDatabase): PersonDao = appDatabase.personDao()
}