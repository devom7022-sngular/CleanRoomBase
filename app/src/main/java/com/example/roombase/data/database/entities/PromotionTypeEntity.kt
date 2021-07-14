package com.example.roombase.data.database.entities

import androidx.room.Entity
import com.example.roombase.data.models.PromotionTypeBo
import com.example.roombase.utils.TABLE_PROMOTION_TYPE

@Entity(tableName = TABLE_PROMOTION_TYPE)
class PromotionTypeEntity(
    var promotionTypeId: Long = 0,
    var imageBadge: String = "",
    var description: String = ""
) : BaseEntity<PromotionTypeBo> {
    override fun toBo(): PromotionTypeBo {
        return PromotionTypeBo(
            promotionTypeId = promotionTypeId,
            imageBadge = imageBadge,
            description = description
        )
    }
}