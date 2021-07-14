package com.example.roombase.data.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import com.example.roombase.data.models.PromotionBo
import com.example.roombase.data.models.PromotionWithItsTypeBo
import com.example.roombase.utils.TABLE_PROMOTION_WITH_ITS_TYPE

@Entity(tableName = TABLE_PROMOTION_WITH_ITS_TYPE)
class PromotionWithItsTypeEntity(
    @Embedded var promotionTypeEntity: PromotionTypeEntity,
    @Relation(
        parentColumn = "promotionTypeId",
        entityColumn = "promotionTypeId"
    )
    var promotionsEntity: List<PromotionEntity>,
) : BaseEntity<PromotionWithItsTypeBo>{
    override fun toBo(): PromotionWithItsTypeBo {
         return PromotionWithItsTypeBo(
             promotionTypeBo = promotionTypeEntity.toBo(),
             promotionsBo = promotionsToBo(promotionsEntity)
         )
    }

    private fun promotionsToBo(promotionsEntity: List<PromotionEntity>): List<PromotionBo> {
         val list: MutableList<PromotionBo> = mutableListOf()

        promotionsEntity.map { list.add(it.toBo()) }

        return list
    }
}