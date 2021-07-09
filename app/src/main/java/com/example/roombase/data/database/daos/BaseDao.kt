package com.example.roombase.data.database.daos

import androidx.room.*
import io.reactivex.Single

interface BaseDao<T> {

    /**
     * Insert an object on db
     *
     * @param obj object to be inserted
     *
     * @return single event
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(obj: T): Single<Long>

    /**
     * Insert a list of objects on db
     *
     * @param obj objects to be inserted
     *
     * @return single event
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg obj: T): Single<Array<Long>>

    /**
     * Update an object from the db
     *
     * @param obj Object to be updated
     *
     * @return single event
     */
    @Update
    fun update(obj: T): Single<Int>

    /**
     * Delete an object from the database
     *
     * @param obj the object to be deleted
     *
     * @return single event
     */
    @Delete
    fun delete(obj: T): Single<Int>
}