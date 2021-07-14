package com.example.roombase.data.database.entities

import androidx.room.Entity
import com.example.roombase.data.models.PromotionHasProductBo
import com.example.roombase.utils.TABLE_PROMOTION_HAS_PRODUCT

@Entity(tableName = TABLE_PROMOTION_HAS_PRODUCT, primaryKeys = ["promotionId", "productId"])
data class PromotionHasProductEntity(
    var promotionId: Int,
    var productId: Int,

    ) : BaseEntity<PromotionHasProductBo> {
    override fun toBo(): PromotionHasProductBo {
        return PromotionHasProductBo(
            promotionId = promotionId,
            productId = productId
        )
    }
}