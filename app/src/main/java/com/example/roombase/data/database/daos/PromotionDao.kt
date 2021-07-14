package com.example.roombase.data.database.daos

import androidx.room.*
import com.example.roombase.data.database.entities.PromotionEntity
import com.example.roombase.data.database.entities.PromotionWithItsTypeEntity
import com.example.roombase.data.database.entities.PromotionWithProductsEntity

/**
 * PromotionDao
 */
@Dao
interface PromotionDao : BaseDao<PromotionEntity> {

    /**
     * Query method to get all promotions
     */
    @Query("SELECT * FROM promotion")
    suspend fun getPromotions(): List<PromotionEntity>

    /**
     * Query method to get promotion by promotionId
     *
     * @param promotionId promotionId value
     */
    @Transaction
    @Query("SELECT * FROM promotion WHERE promotionId = :promotionId")
    suspend fun findPromotionById(promotionId: Int) : PromotionEntity

    /**
     * Query method to get products and promotions
     * 1:N Relation
     */
    @Transaction
    @Query("SELECT * FROM promotion")
    suspend fun getPromotionWithProducts() : List<PromotionWithProductsEntity>

    /**
     * Query method to get promotionType and promotions
     * 1:N Relation
     */
    @Transaction
    @Query("SELECT * FROM promotionType WHERE promotionTypeId =:promotionTypeId")
    suspend fun getPromotionsWithType(promotionTypeId: Int) : List<PromotionWithItsTypeEntity>

    /**
     * Insert method to set promotions
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePromotions(promotionsEntity: List<PromotionEntity>)
}