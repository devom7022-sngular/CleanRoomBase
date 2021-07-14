package com.example.roombase.data.database.daos

import androidx.room.*
import com.example.roombase.data.database.entities.ProductEntity
import com.example.roombase.data.database.entities.ProductWithShoppingCartsEntity
import com.example.roombase.data.database.entities.PromotionWithProductsEntity
import com.example.roombase.data.database.entities.ShoppingCartWithProductsEntity
import com.modelorama.pos.data.database.entities.ShoppingCartEntity

/**
 * ShoppingCartDao
 */
@Dao
interface ShoppingCartDao : BaseDao<ProductEntity> {

    /**
    * Query method to get all shopping carts
    */
    @Query("SELECT * FROM shoppingCart")
    suspend fun getShoppingCarts(): List<ShoppingCartEntity>

    /**
     * Query method to get shopping cart by id
     *
     * @param id shopiing cart id value
     */
    @Transaction
    @Query("SELECT * FROM shoppingCart WHERE shoppingCartId = :shoppingCartId")
    suspend fun findShoppingCartById(shoppingCartId: Long) : ShoppingCartEntity

    /**
     * Query method to get shopping carts and orders
     * 1:1 Relation
     */
    //@Transaction
    //@Query("SELECT * FROM shoppingCart")
    //suspend fun getShoppingCartAndOrders() : List<ShoppingCartAndOrder>

    /**
     * Query method to get shoppingCart and products
     * 1:N Relation
     */
    @Transaction
    @Query("SELECT * FROM shoppingCart")
    suspend fun getShoppingCartWithProducts(): List<ShoppingCartWithProductsEntity>

    /**
     * Query method to get products and shoppingCarts
     * 1:N Relation
     */
    @Transaction
    @Query("SELECT * FROM shoppingCart WHERE shoppingCartId = :shoppingCartId")
    suspend fun getShoppingCartByIdWithProducts(shoppingCartId: Long): List<ShoppingCartWithProductsEntity>

    /**
     * Insert method to set products
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveProducts(shoppingCartEntity: List<ShoppingCartEntity>)
}