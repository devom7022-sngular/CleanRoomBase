package com.example.roombase.data.database.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.roombase.data.models.ProductWithShoppingCartsBo
import com.modelorama.pos.data.database.entities.ShoppingCartEntity
import com.modelorama.pos.domain.model.bo.ShoppingCartBo

class ProductWithShoppingCartsEntity(
    @Embedded
    var productEntity: ProductEntity,
    @Relation(
        parentColumn = "productId",
        entityColumn = "shoppingCartId",
        associateBy = Junction(ShoppingCartHasProductEntity::class)
    )
    var shoppingCartsEntity: List<ShoppingCartEntity>,
): BaseEntity<ProductWithShoppingCartsBo> {
    override fun toBo(): ProductWithShoppingCartsBo {
      return ProductWithShoppingCartsBo(
          productBo = productEntity.toBo(),
          shoppingCartsBo = shoppingCartToBo(shoppingCartsEntity)
      )
    }

    private fun shoppingCartToBo(shoppingCartsEntity: List<ShoppingCartEntity>): List<ShoppingCartBo> {
        val list: MutableList<ShoppingCartBo> = mutableListOf()

        shoppingCartsEntity.map { list.add(it.toBo()) }

        return list
    }
}