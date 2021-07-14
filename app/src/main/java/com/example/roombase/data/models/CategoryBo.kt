package com.example.roombase.data.models

import android.os.Parcelable
import com.example.roombase.data.database.entities.CategoryEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryBo(
    var categoryId: Long,
    var name: String,
    var image: String = "",
    var showOrder: Int,
    var isVisibleInApp: Boolean = true,
    var categoryTypeId: String,
) : Parcelable, BaseBo<CategoryEntity> {
    override fun toEntity(): CategoryEntity {
        return CategoryEntity(
            categoryId = categoryId,
            name = name,
            showOrder = showOrder,
            isVisibleInApp = isVisibleInApp,
            categoryTypeId = categoryTypeId
        )
    }
}