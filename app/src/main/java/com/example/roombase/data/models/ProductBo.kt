package com.example.roombase.data.models

import android.os.Parcelable
import com.example.roombase.data.database.entities.ProductEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductBo(
    var productId: String = "",
    var name: String = "",
    var skuId: String = "",
    var description: String? = "",
    var refId: String? = "",
    var imageUrl: String? = "",
    var price: String = "",
    var inventory: String? = "",
    var isVisibleInApp: Boolean,
    var isTopSeller: Boolean,
    var isPromotion: Boolean,
    var categoryId: Long
) : Parcelable, BaseBo<ProductEntity> {
    override fun toEntity(): ProductEntity {
        return ProductEntity(
            productId = productId,
            name = name,
            skuId = skuId,
            description = description,
            refId = refId,
            imageUrl = imageUrl,
            price = price,
            inventory = inventory,
            isVisibleInApp = isVisibleInApp,
            isTopSeller = isTopSeller,
            isPromotion = isPromotion,
            categoryId = categoryId
        )
    }
}