package com.example.roombase.data.database.daos

import androidx.room.*
import com.example.roombase.data.database.entities.ProductEntity
import com.example.roombase.data.database.entities.ProductWithItsEansEntity
import com.example.roombase.data.database.entities.ProductWithShoppingCartsEntity
import com.example.roombase.data.database.entities.PromotionWithProductsEntity

/**
 * ProductDao
 */
@Dao
interface ProductDao : BaseDao<ProductEntity> {

    /**
     * Query method to get all shopping carts
     */
    @Query("SELECT * FROM product")
    suspend fun getProducts(): List<ProductEntity>

    /**
     * Query method to get shopping cart by id
     *
     * @param productId product id value
     */
    @Transaction
    @Query("SELECT * FROM product WHERE productId = :productId")
    suspend fun findShoppingCartById(productId: Long): ProductEntity

    /**
     * Query method to get products and eanCodes
     * 1:N Relation
     */
    @Transaction
    @Query("SELECT * FROM product")
    suspend fun getProductWithEanCodes(): List<ProductWithItsEansEntity>

    /**
     * Query method to get product by id and eanCodes
     * 1:N Relation
     */
    @Transaction
    @Query("SELECT * FROM product WHERE productId = :productId")
    suspend fun getProductByIdWithEanCodes(productId: Long): List<ProductWithItsEansEntity>

    /**
     * Query method to get products and promotions
     * 1:N Relation
     */
    @Transaction
    @Query("SELECT * FROM product")
    suspend fun getProductWithPromotions(): List<PromotionWithProductsEntity>

    /**
     * Query method to get products and shoppingCarts
     * 1:N Relation
     */
    @Transaction
    @Query("SELECT * FROM product")
    suspend fun getProductWithShoppingCarts(): List<ProductWithShoppingCartsEntity>

    /**
     * Query method to get products and shoppingCarts
     * 1:N Relation
     */
    @Transaction
    @Query("SELECT * FROM product WHERE product.productId = :productId")
    suspend fun getProductByIdWithShoppingCarts(productId: Long): List<ProductWithShoppingCartsEntity>

    /**
     * Insert method to set products
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveProducts(productsEntity: List<ProductEntity>)
}