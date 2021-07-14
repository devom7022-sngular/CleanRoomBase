package com.example.roombase.data.database.daos

import androidx.room.*
import com.example.roombase.data.database.entities.CategoryEntity
import com.example.roombase.data.database.entities.CategoryWithItsTypeEntity
import com.example.roombase.data.database.entities.ProductEntity
import com.example.roombase.data.database.entities.ProductWithPromotionsEntity
import io.reactivex.Observable

/**
 * CategoryDao
 */
@Dao
interface CategoryDao : BaseDao<ProductEntity>  {

    /**
     * Query method to get all shopping carts
     */
    @Query("SELECT * FROM category")
    suspend fun getCategories(): List<CategoryEntity>

    /**
     * Query method to get shopping cart by id
     *
     * @param id shopiing cart id value
     */
    @Transaction
    @Query("SELECT * FROM category WHERE categoryId = :categoryId")
    suspend fun findCategoryById(categoryId: Long) : CategoryEntity

    /**
     * Query method to get CategoryType and category
     * 1:N Relation
     */
    @Query("SELECT * from categoryType WHERE categoryTypeId == :categoryTypeId")
    fun getCategoryWithItsType(categoryTypeId: String): List<CategoryWithItsTypeEntity>

    /**
     * Insert method to set categories
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCategories(categoriesEntity: List<CategoryEntity>)
}