package com.example.roombase.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.roombase.data.database.daos.PersonDao
import com.example.roombase.data.database.entities.PersonEntity

/**
 * AppDatabase
 */
@Database(
    entities = [
        PersonEntity::class,
    ], version = 1, exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "base-db"
    }

    // DAOs Declaration

    /**
     * Method to get person DAO
     *
     * @return person dao
     */
    abstract fun personDao(): PersonDao

}