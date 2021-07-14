package com.example.roombase.data.models

import android.os.Parcelable
import com.example.roombase.data.database.entities.PromotionEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
class PromotionBo(
    var promotionId: Long = 0,
    var name: String = "",
    var description: String = "",
    var beginDate: String = "",
    var endDate: String = "",
    var isActive: String = "",
    var minimumQuantity: String = "",
    var promotionTypeId: Int = 0,
) : Parcelable, BaseBo<PromotionEntity> {
    override fun toEntity(): PromotionEntity {
        return PromotionEntity(
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