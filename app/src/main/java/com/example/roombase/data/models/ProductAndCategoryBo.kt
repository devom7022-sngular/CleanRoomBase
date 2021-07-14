package com.example.roombase.data.models

import android.os.Parcelable
import com.example.roombase.data.database.entities.ProductAndCategoryEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
class ProductAndCategoryBo(
    var productBo: ProductBo,
    var categoryBo: CategoryBo,
) : Parcelable, BaseBo<ProductAndCategoryEntity> {
    override fun toEntity(): ProductAndCategoryEntity {
        return ProductAndCategoryEntity(
            productEntity = productBo.toEntity(),
            categoryEntity = categoryBo.toEntity(),
        )
    }
}