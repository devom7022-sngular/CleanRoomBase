package com.example.roombase.data.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
import com.example.roombase.data.models.ProductWithPromotionsBo
import com.example.roombase.data.models.PromotionBo

//@Entity(tableName = TABLE_PRODUCT_WITH_PROMOTIONS)
class ProductWithPromotionsEntity(
    @Embedded val productEntity: ProductEntity,
    @Relation(
        parentColumn = "productId",
        entityColumn = "promotionId",
        associateBy = Junction(PromotionHasProductEntity::class)
    )
    val promotionsEntity: List<PromotionEntity>,
) : BaseEntity<ProductWithPromotionsBo> {
    override fun toBo(): ProductWithPromotionsBo {
        return ProductWithPromotionsBo(
            productBo = productEntity.toBo(),
            promotionsBo = promotionsToBo(promotionsEntity)
        )
    }

    private fun promotionsToBo(promotionsEntity: List<PromotionEntity>): List<PromotionBo> {

        val list: MutableList<PromotionBo> = mutableListOf()

        promotionsEntity.map { list.add(it.toBo()) }

        return list
    }
}