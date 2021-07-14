package com.example.roombase.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.example.roombase.data.models.ProductBo
import com.example.roombase.utils.TABLE_PRODUCT
import com.google.gson.annotations.SerializedName

@Entity(tableName = TABLE_PRODUCT)
class ProductEntity(
    @SerializedName("productId") @PrimaryKey @ColumnInfo(name = "productId") var productId: String = "",
    @SerializedName("productName")  @ColumnInfo(name = "name") var name: String = "",
    @SerializedName("skuId") var skuId: String = "",
    @SerializedName("productDescription") @ColumnInfo(name = "description") var description: String? = "",
    @SerializedName("productRefId")  @ColumnInfo(name = "refId") var refId: String? = "",
    @SerializedName("imageUrl") var imageUrl: String? = "",
    @SerializedName("productPrice") @ColumnInfo(name = "price") var price: String = "",
    @SerializedName("productInventory") @ColumnInfo(name = "inventory") var inventory: String? = "",
    @SerializedName("isVisibleInApp") var isVisibleInApp: Boolean = true,
    @SerializedName("isTopSeller") var isTopSeller: Boolean = false,
    @SerializedName("isPromotion") var isPromotion: Boolean = false,
    @SerializedName("categoryId") var categoryId: Long,
) : BaseEntity<ProductBo> {
    override fun toBo(): ProductBo {
        return ProductBo(
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