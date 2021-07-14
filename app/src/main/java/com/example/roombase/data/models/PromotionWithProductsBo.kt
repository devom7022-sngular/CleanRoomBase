package com.example.roombase.data.models

import android.os.Parcelable
import com.example.roombase.data.database.entities.ProductEntity
import com.example.roombase.data.database.entities.PromotionWithProductsEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class PromotionWithProductsBo(
    val promotionBo: PromotionBo,
    val productsBo: List<ProductBo>,
) : Parcelable, BaseBo<PromotionWithProductsEntity> {
    override fun toEntity(): PromotionWithProductsEntity {
        return PromotionWithProductsEntity(
            promotionEntity = promotionBo.toEntity(),
            productsEntity = productsToBo(productsBo)
        )
    }

    private fun productsToBo(productsBo: List<ProductBo>): List<ProductEntity> {

        val list: MutableList<ProductEntity> = mutableListOf()

        productsBo.map { list.add(it.toEntity()) }

        return list
    }
}