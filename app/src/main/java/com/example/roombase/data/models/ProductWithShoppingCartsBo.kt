package com.example.roombase.data.models

import android.os.Parcelable
import com.example.roombase.data.database.entities.ProductWithShoppingCartsEntity
import com.modelorama.pos.data.database.entities.ShoppingCartEntity
import com.modelorama.pos.domain.model.bo.ShoppingCartBo
import kotlinx.parcelize.Parcelize

@Parcelize
class ProductWithShoppingCartsBo(
    var productBo: ProductBo,
    var shoppingCartsBo: List<ShoppingCartBo>,
) : Parcelable, BaseBo<ProductWithShoppingCartsEntity> {
    override fun toEntity(): ProductWithShoppingCartsEntity {
        return ProductWithShoppingCartsEntity(
            productEntity = productBo.toEntity(),
            shoppingCartsEntity = shoppingCartToEntity(shoppingCartsBo)
        )
    }

    private fun shoppingCartToEntity(shoppingCartsBo: List<ShoppingCartBo>): List<ShoppingCartEntity> {

        val list: MutableList<ShoppingCartEntity> = mutableListOf()

        shoppingCartsBo.map { list.add(it.toEntity()) }

        return list
    }
}