package com.example.roombase.data.database.entities

import androidx.room.Entity
import com.example.roombase.data.models.ShoppingCartHasProductBo
import com.example.roombase.utils.TABLE_SHOPPING_HAS_PRODUCT

@Entity(tableName = TABLE_SHOPPING_HAS_PRODUCT,
    primaryKeys = ["productId", "shoppingCartId", "simulateOrder"])
class ShoppingCartHasProductEntity(
    var productId: Long,
    var shoppingCartId: Long,
    var simulateOrder: Int,
    var quantity: String,
    var price: String,
    var listPrice: String,
    var sellingPrice: String,
    var priceTags: String,
    var isSkipped: Boolean,
) : BaseEntity<ShoppingCartHasProductBo> {
    override fun toBo(): ShoppingCartHasProductBo {
        return ShoppingCartHasProductBo(
            productId = productId,
            shoppingCartId = shoppingCartId,
            simulateOrder = simulateOrder,
            quantity = quantity,
            price = price,
            listPrice = listPrice,
            sellingPrice = sellingPrice,
            priceTags = priceTags,
            isSkipped = isSkipped,
        )
    }
}