package com.example.roombase.data.models

import android.os.Parcelable
import com.example.roombase.data.database.entities.PromotionHasProductEntity
import kotlinx.parcelize.Parcelize

@Parcelize
class PromotionHasProductBo(
    var promotionId: Int,
    var productId: Int,
) : Parcelable, BaseBo<PromotionHasProductEntity> {
    override fun toEntity(): PromotionHasProductEntity {
        return PromotionHasProductEntity(
            promotionId = promotionId,
            productId = productId
        )
    }
}