package com.example.roombase.data.database.entities

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roombase.data.models.EanCodeBo
import com.example.roombase.data.models.ProductWithItsEansBo

class ProductWithItsEansEntity(
    @Embedded var productEntity: ProductEntity,
    @Relation(
        parentColumn = "productId",
        entityColumn = "productId"
    )
    var eanCodesEntity: List<EanCodeEntity>,
) : BaseEntity<ProductWithItsEansBo> {
    override fun toBo(): ProductWithItsEansBo {
        return ProductWithItsEansBo(
            productBo = productEntity.toBo(),
            eanCodesBo = eanCodesToBo(eanCodesEntity)
        )
    }

    private fun eanCodesToBo(eanCodesEntity: List<EanCodeEntity>): List<EanCodeBo> {

        val list: MutableList<EanCodeBo> = mutableListOf()

        eanCodesEntity.map { list.add(it.toBo()) }

        return list
    }
}