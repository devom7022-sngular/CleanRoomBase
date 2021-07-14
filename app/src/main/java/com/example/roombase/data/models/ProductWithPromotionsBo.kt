package com.example.roombase.data.models

import android.os.Parcelable
import com.example.roombase.data.database.entities.ProductWithPromotionsEntity
import com.example.roombase.data.database.entities.PromotionEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductWithPromotionsBo(
    val productBo: ProductBo,
    val promotionsBo: List<PromotionBo>,
) : Parcelable, BaseBo<ProductWithPromotionsEntity> {
    override fun toEntity(): ProductWithPromotionsEntity {
        return ProductWithPromotionsEntity(
            productEntity = productBo.toEntity(),
            promotionsEntity = promotionsToEntity(promotionsBo)
        )
    }

    private fun promotionsToEntity(promotionsBo: List<PromotionBo>): List<PromotionEntity> {

        val list: MutableList<PromotionEntity> = mutableListOf()

        promotionsBo.map { list.add(it.toEntity()) }

        return list
    }
}