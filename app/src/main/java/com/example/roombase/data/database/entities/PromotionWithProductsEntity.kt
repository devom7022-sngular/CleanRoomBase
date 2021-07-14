package com.example.roombase.data.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
import com.example.roombase.data.models.ProductBo
import com.example.roombase.data.models.PromotionWithProductsBo

//@Entity(tableName = TABLE_PROMOTION_WITH_PRODUCTS)
class PromotionWithProductsEntity(
    @Embedded val promotionEntity: PromotionEntity,
    @Relation(
        parentColumn = "promotionId",
        entityColumn = "productId",
        associateBy = Junction(PromotionHasProductEntity::class)
    )
    val productsEntity: List<ProductEntity>,

    ) : BaseEntity<PromotionWithProductsBo> {
    override fun toBo(): PromotionWithProductsBo {
        return PromotionWithProductsBo(
            promotionBo = promotionEntity.toBo(),
            productsBo = promotionsToBo(productsEntity)
        )
    }

    private fun promotionsToBo(productsEntity: List<ProductEntity>): List<ProductBo> {

        val list: MutableList<ProductBo> = mutableListOf()

        productsEntity.map { list.add(it.toBo()) }

        return list
    }

}