package com.example.roombase.data.models

import android.os.Parcelable
import com.example.roombase.data.database.entities.PromotionTypeEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PromotionTypeBo(
    var promotionTypeId: Long,
    var imageBadge: String = "",
    var description: String = ""
) : Parcelable, BaseBo<PromotionTypeEntity> {
    override fun toEntity(): PromotionTypeEntity {
        return PromotionTypeEntity(
            promotionTypeId = promotionTypeId,
            imageBadge = imageBadge,
            description = description
        )
    }
}