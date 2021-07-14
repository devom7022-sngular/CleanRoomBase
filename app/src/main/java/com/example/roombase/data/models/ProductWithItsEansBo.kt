package com.example.roombase.data.models

import android.os.Parcelable
import com.example.roombase.data.database.entities.CategoryEntity
import com.example.roombase.data.database.entities.EanCodeEntity
import com.example.roombase.data.database.entities.ProductWithItsEansEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductWithItsEansBo(
    var productBo: ProductBo,
    var eanCodesBo: List<EanCodeBo>,
) : Parcelable, BaseBo<ProductWithItsEansEntity> {
    override fun toEntity(): ProductWithItsEansEntity {
        return ProductWithItsEansEntity(
            productEntity = productBo.toEntity(),
            eanCodesEntity = eanCodesToEntity(eanCodesBo)
        )
    }

    private fun eanCodesToEntity(eanCodesBo: List<EanCodeBo>): List<EanCodeEntity> {

        val list: MutableList<EanCodeEntity> = mutableListOf()

        eanCodesBo.map { list.add(it.toEntity()) }

        return list
    }
}