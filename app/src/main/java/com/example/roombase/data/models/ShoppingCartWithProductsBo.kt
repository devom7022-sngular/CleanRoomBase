package com.example.roombase.data.models

import android.os.Parcelable
import com.example.roombase.data.database.entities.ProductEntity
import com.example.roombase.data.database.entities.PromotionEntity
import com.example.roombase.data.database.entities.ShoppingCartWithProductsEntity
import com.modelorama.pos.domain.model.bo.ShoppingCartBo
import kotlinx.parcelize.Parcelize

@Parcelize
class ShoppingCartWithProductsBo(
    var shoppingCartBo: ShoppingCartBo,
    var productsBo: List<ProductBo>,
) : Parcelable, BaseBo<ShoppingCartWithProductsEntity> {
    override fun toEntity(): ShoppingCartWithProductsEntity {
        return ShoppingCartWithProductsEntity(
            shoppingCartEntity = shoppingCartBo.toEntity(),
            productsEntity = promotionsToEntity(productsBo)
        )
    }

    private fun promotionsToEntity(productsBo: List<ProductBo>): List<ProductEntity> {

        val list: MutableList<ProductEntity> = mutableListOf()

        productsBo.map { list.add(it.toEntity()) }

        return list
    }
}