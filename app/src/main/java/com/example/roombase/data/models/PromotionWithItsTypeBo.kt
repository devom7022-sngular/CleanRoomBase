package com.example.roombase.data.models

import android.os.Parcelable
import com.example.roombase.data.database.entities.PromotionEntity
import com.example.roombase.data.database.entities.PromotionWithItsTypeEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class PromotionWithItsTypeBo(
    var promotionTypeBo: PromotionTypeBo,
    var promotionsBo: List<PromotionBo>,
) : Parcelable, BaseBo<PromotionWithItsTypeEntity> {
    override fun toEntity(): PromotionWithItsTypeEntity {
        return PromotionWithItsTypeEntity(
            promotionTypeEntity = promotionTypeBo.toEntity(),
            promotionsEntity = promotionsToEntity(promotionsBo)
        )
    }

    private fun promotionsToEntity(promotionBo: List<PromotionBo>): List<PromotionEntity> {

        val list: MutableList<PromotionEntity> = mutableListOf()

        promotionBo.map { list.add(it.toEntity()) }

        return list
    }
}