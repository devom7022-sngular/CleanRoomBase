package com.modelorama.pos.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.roombase.data.database.entities.BaseEntity
import com.example.roombase.utils.TABLE_SHOPPING_CART
import com.modelorama.pos.domain.model.bo.ShoppingCartBo

@Entity(tableName = TABLE_SHOPPING_CART)
data class ShoppingCartEntity(
    @PrimaryKey(autoGenerate = true) var shoppingCartId: Long = 0,
    var status: String = "",
    var total: String = "",
    var totalDiscount: String = ""
) : BaseEntity<ShoppingCartBo> {

    override fun toBo(): ShoppingCartBo =
        ShoppingCartBo(
            shoppingCartId = shoppingCartId,
            status = status,
            total = total,
            totalDiscount = totalDiscount)

}