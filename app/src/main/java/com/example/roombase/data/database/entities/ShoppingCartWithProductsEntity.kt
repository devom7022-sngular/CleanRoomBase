package com.example.roombase.data.database.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.roombase.data.models.ProductBo
import com.example.roombase.data.models.ShoppingCartWithProductsBo
import com.modelorama.pos.data.database.entities.ShoppingCartEntity

class ShoppingCartWithProductsEntity(
    @Embedded
    var shoppingCartEntity: ShoppingCartEntity,
    @Relation(
        parentColumn = "shoppingCartId",
        entityColumn = "productId",
        associateBy = Junction(ShoppingCartHasProductEntity::class)
    )
    var productsEntity: List<ProductEntity>,
) : BaseEntity<ShoppingCartWithProductsBo>{
    override fun toBo(): ShoppingCartWithProductsBo {
        return ShoppingCartWithProductsBo(
            shoppingCartBo = shoppingCartEntity.toBo(),
            productsBo = productsToBo(productsEntity)
        )
    }

    private fun productsToBo(productsEntity: List<ProductEntity>): List<ProductBo> {

        val list: MutableList<ProductBo> = mutableListOf()

        productsEntity.map { list.add(it.toBo()) }

        return list
    }
}