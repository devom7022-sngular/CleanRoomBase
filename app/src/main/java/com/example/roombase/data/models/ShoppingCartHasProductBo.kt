package com.example.roombase.data.models

import android.os.Parcelable
import com.example.roombase.data.database.entities.ShoppingCartHasProductEntity

import kotlinx.parcelize.Parcelize

@Parcelize
class ShoppingCartHasProductBo(
    var productId: Long,
    var shoppingCartId: Long,
    var simulateOrder: Int,
    var quantity: String,
    var price: String,
    var listPrice: String,
    var sellingPrice: String,
    var priceTags: String,
    var isSkipped: Boolean,

) : Parcelable, BaseBo<ShoppingCartHasProductEntity> {
    override fun toEntity(): ShoppingCartHasProductEntity {
        return ShoppingCartHasProductEntity(
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