package com.example.roombase.data.database.entities

import androidx.room.Entity
import com.example.roombase.data.models.PromotionBo
import com.example.roombase.utils.TABLE_PROMOTION

@Entity(tableName = TABLE_PROMOTION)
class PromotionEntity(
    var promotionId: Long = 0,
    var name: String = "",
    var description: String = "",
    var beginDate: String = "",
    var endDate: String = "",
    var isActive: String = "",
    var minimumQuantity: String = "",
    var promotionTypeId: Int = 0
) : BaseEntity<PromotionBo> {
    override fun toBo(): PromotionBo {
        return PromotionBo(
            promotionId = promotionId,
            name = name,
            description = description,
            beginDate = beginDate,
            endDate = endDate,
            isActive = isActive,
            minimumQuantity = minimumQuantity,
            promotionTypeId = promotionTypeId
        )
    }
}