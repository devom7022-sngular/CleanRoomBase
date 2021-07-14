package com.example.roombase.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roombase.data.database.entities.CategoryEntity
import io.reactivex.Observable

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllCategories(categoriesEntity: List<CategoryEntity>)

    @Query("SELECT * from category WHERE isVisibleInApp == 1 ORDER BY showOrder ASC")
    fun getAllCategories(): Observable<List<CategoryEntity>>

    @Query("SELECT * from category WHERE isVisibleInApp == 1 AND id == :id")
    fun getCategoryById(id: String): CategoryEntity
}